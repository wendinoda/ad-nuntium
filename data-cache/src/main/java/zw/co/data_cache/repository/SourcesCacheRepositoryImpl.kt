package zw.co.data_cache.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.map
import zw.co.data.model.SourceDataModel
import zw.co.data.repository.sources.SourcesCacheRepository
import zw.co.data_cache.Preferences
import zw.co.data_cache.db.AdNuntiumDB
import zw.co.data_cache.mapper.SourcesEntityMapper
import javax.inject.Inject

class SourcesCacheRepositoryImpl @Inject constructor(
    private val db: AdNuntiumDB,
    private val mapper: SourcesEntityMapper,
    private val prefs: Preferences
) : SourcesCacheRepository {

    /**
     * 30 days
     */
    private val EXPIRATION_TIME = (2.592 * 100000 * 10000).toLong()

    internal fun getDatabase(): AdNuntiumDB {
        return db
    }

    override suspend fun clearSources() {
        db.sourcesDao().clearSources()
    }

    override suspend fun saveSources(sources: List<SourceDataModel>) {
        db.sourcesDao().insertSources(
            *sources.map {
                mapper.mapToCached(it)
            }.toTypedArray()
        )
    }

    override suspend fun getSources(): Flow<List<SourceDataModel>> {
        return db.sourcesDao().getSources().map {
            it.map { source ->
                mapper.mapFromCached(source)
            }
        }
    }

    override suspend fun isCached(): Boolean {
        return db.sourcesDao().getSources().map {
            it.size
        }.count() > 0
    }

    override fun setLastCacheTime(lastCache: Long) {
        prefs.lastCacheTimeSources = lastCache
    }

    override fun isExpired(): Boolean {
        val currentTime = System.currentTimeMillis()
        val lastUpdateTime = getLastCacheUpdateTimeMillis()
        return currentTime - lastUpdateTime > EXPIRATION_TIME
    }

    private fun getLastCacheUpdateTimeMillis(): Long {
        return prefs.lastCacheTimeSources
    }
}