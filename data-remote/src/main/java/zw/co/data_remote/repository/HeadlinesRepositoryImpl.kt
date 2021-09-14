package zw.co.data_remote.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import zw.co.data.model.HeadlinesDataModel
import zw.co.data.repository.headlines.HeadlinesRemoteRepository
import zw.co.data_remote.BuildConfig
import zw.co.data_remote.mapper.HeadlinesEntityMapper
import zw.co.data_remote.network.RestService
import javax.inject.Inject

class HeadlinesRepositoryImpl @Inject constructor(
    private val remote: RestService,
    private val mapper: HeadlinesEntityMapper
) : HeadlinesRemoteRepository {
    override suspend fun getHeadlines(): Flow<HeadlinesDataModel> {
        val headlinesEntity = remote.getHeadlines()
        val headlines = mapper.mapFromEntity(headlinesEntity)
        return flowOf(headlines)
    }

    override suspend fun getHeadlinesByCategory(category: String): Flow<HeadlinesDataModel> {
        val headlinesByCategoryEntity = remote.getHeadlinesByCategory(category)
        val headlinesCategory = mapper.mapFromEntity(headlinesByCategoryEntity)
        return flowOf(headlinesCategory)
    }
}