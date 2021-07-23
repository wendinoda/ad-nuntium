package zw.co.data.source.headlines

import kotlinx.coroutines.flow.Flow
import zw.co.data.model.ArticlesDataModel
import zw.co.data.model.HeadlinesDataModel
import zw.co.data.repository.headlines.HeadlinesRemoteRepository
import zw.co.data.repository.headlines.HeadlinesRepository
import javax.inject.Inject

class HeadlinesRemoteSource @Inject constructor(
    private val headlinesRemote: HeadlinesRemoteRepository
): HeadlinesRepository {
    override suspend fun getHeadlines(): Flow<HeadlinesDataModel> {
        return headlinesRemote.getHeadlines()
    }

    override suspend fun getHeadlinesByCategory(category: String): Flow<HeadlinesDataModel> {
        return headlinesRemote.getHeadlinesByCategory(category)
    }

    override suspend fun clearHeadlines() {
        throw UnsupportedOperationException()
    }

    override suspend fun saveHeadlines(headlines: List<ArticlesDataModel>) {
        throw UnsupportedOperationException()
    }

    override suspend fun isCached(): Boolean {
        throw UnsupportedOperationException()
    }
}