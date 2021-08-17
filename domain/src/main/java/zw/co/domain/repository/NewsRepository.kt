package zw.co.domain.repository

import kotlinx.coroutines.flow.Flow
import zw.co.domain.model.Articles
import zw.co.domain.model.News

interface NewsRepository {
    suspend fun getNewsStories(): Flow<News>

    suspend fun clearNewsStories()

    suspend fun saveNewsStories(news: List<Articles>)
}