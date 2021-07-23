package zw.co.data.repository.headlines

import kotlinx.coroutines.flow.Flow
import zw.co.data.model.ArticlesDataModel

interface HeadlinesCacheRepository {
    suspend fun getHeadlines(): Flow<List<ArticlesDataModel>>

    suspend fun clearHeadlines()

    suspend fun saveHeadlines(headlines: List<ArticlesDataModel>)

    fun setLastCacheTime(lastCache: Long)

    fun isExpired(): Boolean
}