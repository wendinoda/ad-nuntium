package zw.co.data.source.headlines

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import zw.co.data.model.ArticlesDataModel
import zw.co.data.model.HeadlinesDataModel
import zw.co.data.repository.headlines.HeadlinesCacheRepository
import zw.co.data.repository.headlines.HeadlinesRepository
import java.lang.UnsupportedOperationException
import javax.inject.Inject

class HeadlinesCacheSource @Inject constructor(
    private val headlinesCache: HeadlinesCacheRepository
): HeadlinesRepository {
    override suspend fun getHeadlines(): Flow<HeadlinesDataModel> {
        val headlines = headlinesCache.getHeadlines()
        return headlines.map {
            HeadlinesDataModel(
                status = "ok",
                totalResults = it.size,
                articles = it
            )
        }
    }

    override suspend fun getHeadlinesByCategory(category: String): Flow<HeadlinesDataModel> {
        throw UnsupportedOperationException()
    }

    override suspend fun clearHeadlines() {
        headlinesCache.clearHeadlines()
    }

    override suspend fun saveHeadlines(headlines: List<ArticlesDataModel>) {
       headlinesCache.saveHeadlines(headlines)
    }

    override suspend fun isCached(): Boolean {
        return headlinesCache.isExpired()
    }
}