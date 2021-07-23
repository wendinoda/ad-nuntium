package zw.co.data.source.sources

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.single
import zw.co.data.model.SourceDataModel
import zw.co.data.model.SourcesSuccessDataModel
import zw.co.data.repository.sources.SourcesCacheRepository
import zw.co.data.repository.sources.SourcesRepository
import javax.inject.Inject

open class SourcesCacheSource @Inject constructor(
    private val sourcesCache: SourcesCacheRepository
) : SourcesRepository {

    override suspend fun getSources(): Flow<SourcesSuccessDataModel> {
        val sources = sourcesCache.getSources()
        return sources.map {
            SourcesSuccessDataModel(
                status = "ok",
                sources = sources.single()
            )
        }
    }

    override suspend fun clearSources() {
        sourcesCache.clearSources()
    }

    override suspend fun saveSources(sources: List<SourceDataModel>) {
        sourcesCache.saveSources(sources)
        sourcesCache.setLastCacheTime(System.currentTimeMillis())
    }

    override suspend fun isCached():  Boolean = sourcesCache.isCached()

}