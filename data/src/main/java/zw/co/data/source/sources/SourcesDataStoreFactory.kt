package zw.co.data.source.sources

import zw.co.data.repository.sources.SourcesCacheRepository
import zw.co.data.repository.sources.SourcesRepository
import javax.inject.Inject

/**
* Create an Instance of [SourcesRemoteSource]
*/

open class SourcesDataStoreFactory @Inject constructor(
    private val sourcesCache: SourcesCacheRepository,
    private val sourcesCacheSource: SourcesCacheSource,
    private val sourcesRemoteSource: SourcesRemoteSource
){
    fun retrieveDataStore(isCached: Boolean): SourcesRepository {
        if (isCached && !sourcesCache.isExpired()) {
            return retrieveCacheDataStore()
        }
        return retrieveRemoteDataStore()
    }

    fun retrieveRemoteDataStore(): SourcesRepository = sourcesRemoteSource

    fun retrieveCacheDataStore(): SourcesRepository = sourcesCacheSource
}