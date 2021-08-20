package zw.co.data.source.news

import zw.co.data.repository.news.NewsRepository
import javax.inject.Inject

open class NewsDataStoreFactory @Inject constructor(
    private val newsRemoteSource: NewsRemoteSource
) {
    open suspend fun retrieveDataStore(): NewsRepository {
        return retrieveRemoteDataStore()
    }

    open suspend fun retrieveRemoteDataStore(): NewsRepository = newsRemoteSource
}