package zw.co.data.repository.news

import kotlinx.coroutines.flow.Flow
import zw.co.data.model.ArticlesDataModel
import zw.co.data.model.NewsDataModel

interface NewsRepository {
    suspend fun getNewsStories(): Flow<NewsDataModel>

    suspend fun clearNewsStories()

    suspend fun saveNewsStories(news: List<ArticlesDataModel>)

    suspend fun isCached(): Boolean
}