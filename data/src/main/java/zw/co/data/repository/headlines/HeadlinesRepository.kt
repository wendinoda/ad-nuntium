package zw.co.data.repository.headlines

import kotlinx.coroutines.flow.Flow
import zw.co.data.model.ArticlesDataModel
import zw.co.data.model.HeadlinesDataModel

interface HeadlinesRepository {
    suspend fun getHeadlines(): Flow<HeadlinesDataModel>

    suspend fun getHeadlinesByCategory(category: String): Flow<HeadlinesDataModel>

    suspend fun clearHeadlines()

    suspend fun saveHeadlines(headlines: List<ArticlesDataModel>)

    suspend fun isCached(): Boolean
}