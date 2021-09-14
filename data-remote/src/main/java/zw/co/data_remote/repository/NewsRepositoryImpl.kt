package zw.co.data_remote.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import zw.co.data.model.NewsDataModel
import zw.co.data.repository.news.NewsRemoteRepository
import zw.co.data_remote.mapper.NewsEntityMapper
import zw.co.data_remote.network.RestService
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val remote: RestService,
    private val mapper: NewsEntityMapper
) : NewsRemoteRepository {
    override suspend fun getNewsStories(): Flow<NewsDataModel> {
        val newsEntity = remote.getNewsStories()
        val news = mapper.mapFromEntity(newsEntity)
        return flowOf(news)
    }
}