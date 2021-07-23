package zw.co.data.repository.headlines

import kotlinx.coroutines.flow.Flow
import zw.co.data.model.HeadlinesDataModel

interface HeadlinesRemoteRepository {
    suspend fun getHeadlines(): Flow<HeadlinesDataModel>

    suspend fun getHeadlinesByCategory(category: String): Flow<HeadlinesDataModel>
}