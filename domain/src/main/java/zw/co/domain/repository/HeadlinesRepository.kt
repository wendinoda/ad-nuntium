package zw.co.domain.repository

import kotlinx.coroutines.flow.Flow
import zw.co.domain.model.Articles
import zw.co.domain.model.Headlines
import zw.co.domain.model.Source

interface HeadlinesRepository {
    suspend fun getAllHeadlines(): Flow<Headlines>

    suspend fun getHeadlinesByCategory(category: String): Flow<Headlines>

    suspend fun clearHeadlines()

    suspend fun saveHeadlines(headlines: List<Articles>)
}