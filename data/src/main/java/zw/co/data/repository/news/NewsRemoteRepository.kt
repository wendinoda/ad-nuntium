package zw.co.data.repository.news

import kotlinx.coroutines.flow.Flow
import zw.co.data.model.NewsDataModel

interface NewsRemoteRepository {
    suspend fun getNewsStories(): Flow<NewsDataModel>
}