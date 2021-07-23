package zw.co.data_cache.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import zw.co.data.model.ArticlesDataModel
import zw.co.data.model.HeadlinesDataModel
import zw.co.data.repository.headlines.HeadlinesCacheRepository
import zw.co.data_cache.Preferences
import zw.co.data_cache.db.AdNuntiumDB
import zw.co.data_cache.mapper.HeadlinesEntityMapper
import javax.inject.Inject

class HeadlinesCacheRepositoryImpl @Inject constructor(
    private val db: AdNuntiumDB,
    private val mapper: HeadlinesEntityMapper,
    private val prefs: Preferences
): HeadlinesCacheRepository {

    /**
     * 2 hours
     */
    private val EXPIRATION_TIME = (7.2 * 1000 * 1000).toLong()

    internal fun getDatabase(): AdNuntiumDB {
        return db
    }

    override suspend fun getHeadlines(): Flow<List<ArticlesDataModel>> {
        return db.headlinesDao().getHeadlines()
            .map {
                it.map { headline ->
                    mapper.mapFromCached(headline)
                }
            }
    }

    override suspend fun clearHeadlines() {
        db.headlinesDao().clearHeadlines()
    }

    override suspend fun saveHeadlines(headlines: List<ArticlesDataModel>) {
        db.headlinesDao().insertHeadlines(
            *headlines.map {
                mapper.mapToCached(it)
            }.toTypedArray()
        )
    }

    override fun setLastCacheTime(lastCache: Long) {
        prefs.lastCacheTimeHeadlines = lastCache
    }

    override fun isExpired(): Boolean {
        val currentTime = System.currentTimeMillis()
        val lastUpdateTime = getLastCacheUpdateTimeMillis()
        return currentTime - lastUpdateTime > EXPIRATION_TIME
    }

    private fun getLastCacheUpdateTimeMillis(): Long {
        return prefs.lastCacheTimeHeadlines
    }
}