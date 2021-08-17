package zw.co.data.repository.news

import kotlinx.coroutines.flow.Flow
import zw.co.data.model.ArticlesDataModel

interface NewsCacheRepository {
    suspend fun getNewsStories(): Flow<List<ArticlesDataModel>>

    suspend fun clearNewsStories()

    suspend fun saveNewsStories(news: List<ArticlesDataModel>)

    fun setLastCacheTime(lastCache: Long)

    fun isExpired(): Boolean
}