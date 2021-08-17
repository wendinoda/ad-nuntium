package zw.co.data.source.news

import kotlinx.coroutines.flow.Flow
import zw.co.data.model.ArticlesDataModel
import zw.co.data.model.NewsDataModel
import zw.co.data.repository.news.NewsRemoteRepository
import zw.co.data.repository.news.NewsRepository
import javax.inject.Inject

class NewsRemoteSource @Inject constructor(
    private val newsRemoteRepository: NewsRemoteRepository
): NewsRepository {
    override suspend fun getNewsStories(): Flow<NewsDataModel> {
        return newsRemoteRepository.getNewsStories()
    }

    override suspend fun clearNewsStories() {
        throw UnsupportedOperationException()
    }

    override suspend fun saveNewsStories(news: List<ArticlesDataModel>) {
        throw UnsupportedOperationException()
    }

    override suspend fun isCached(): Boolean {
        throw UnsupportedOperationException()
    }
}