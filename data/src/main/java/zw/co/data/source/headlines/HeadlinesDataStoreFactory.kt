package zw.co.data.source.headlines

import zw.co.data.repository.headlines.HeadlinesCacheRepository
import zw.co.data.repository.headlines.HeadlinesRepository
import zw.co.data.repository.sources.SourcesRepository
import javax.inject.Inject

open class HeadlinesDataStoreFactory @Inject constructor(
    private val headlinesCache: HeadlinesCacheRepository,
    private val headlinesCacheSource: HeadlinesCacheSource,
    private val headlinesRemoteSource: HeadlinesRemoteSource
) {
    open suspend fun retrieveDataStore(isCached: Boolean): HeadlinesRepository {
        if (isCached && !headlinesCache.isExpired()) {
            return retrieveCacheDataStore()
        }
        return retrieveRemoteDataStore()
    }

    open suspend fun retrieveRemoteDataStore(): HeadlinesRepository = headlinesRemoteSource

    open suspend fun retrieveCacheDataStore(): HeadlinesRepository = headlinesCacheSource
}