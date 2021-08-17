package zw.co.data.source.news

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import zw.co.data.model.ArticlesDataModel
import zw.co.data.model.NewsDataModel
import zw.co.data.repository.news.NewsCacheRepository
import zw.co.data.repository.news.NewsRepository
import javax.inject.Inject

class NewsCacheSource @Inject constructor(
    private val newsCache: NewsCacheRepository
): NewsRepository {
    override suspend fun getNewsStories(): Flow<NewsDataModel> {
        val news = newsCache.getNewsStories()
        return news.map {
            NewsDataModel(
                status = "ok",
                totalResults = it.size,
                articles = it
            )
        }
    }

    override suspend fun clearNewsStories() {
        newsCache.clearNewsStories()
    }

    override suspend fun saveNewsStories(news: List<ArticlesDataModel>) {
        newsCache.saveNewsStories(news)
    }

    override suspend fun isCached(): Boolean {
        return newsCache.isExpired()
    }
}