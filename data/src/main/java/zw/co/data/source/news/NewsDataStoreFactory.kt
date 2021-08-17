package zw.co.data.source.news

import zw.co.data.repository.news.NewsCacheRepository
import zw.co.data.repository.news.NewsRepository
import javax.inject.Inject

open class NewsDataStoreFactory @Inject constructor(
    private val newsCache: NewsCacheRepository,
    private val newsCacheSource: NewsCacheSource,
    private val newsRemoteSource: NewsRemoteSource
) {
    open suspend fun retrieveDataStore(isCached: Boolean): NewsRepository {
        if (isCached && !newsCache.isExpired()) {
            return retrieveCacheDataStore()
        }
        return retrieveRemoteDataStore()
    }

    open suspend fun retrieveRemoteDataStore(): NewsRepository = newsRemoteSource

    open suspend fun retrieveCacheDataStore(): NewsRepository = newsCacheSource
}