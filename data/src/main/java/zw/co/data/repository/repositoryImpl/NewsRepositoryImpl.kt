package zw.co.data.repository.repositoryImpl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import zw.co.data.mapper.HeadlinesDataMapper
import zw.co.data.mapper.NewsDataMapper
import zw.co.data.model.ArticlesDataModel
import zw.co.data.source.news.NewsDataStoreFactory
import zw.co.domain.model.Articles
import zw.co.domain.model.News
import zw.co.domain.repository.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val factory: NewsDataStoreFactory,
    private val newsMapper: NewsDataMapper,
    private val headlinesMapper: HeadlinesDataMapper
): NewsRepository {
    override suspend fun getNewsStories(): Flow<News> {
        return factory.retrieveDataStore(factory.retrieveCacheDataStore().isCached())
            .getNewsStories().map {
                newsMapper.mapFromEntity(it)
            }
    }

    override suspend fun clearNewsStories() {
        factory.retrieveCacheDataStore().clearNewsStories()
    }

    override suspend fun saveNewsStories(news: List<Articles>) {
        val newsDataModel = mutableListOf<ArticlesDataModel>()
        news.map { newsDataModel.add(headlinesMapper.mapToEntity(it)) }
    }
}