package zw.co.data.repository.news

import kotlinx.coroutines.flow.Flow
import zw.co.data.model.ArticlesDataModel
import zw.co.data.model.NewsDataModel

interface NewsRepository {
    suspend fun getNewsStories(): Flow<NewsDataModel>
}