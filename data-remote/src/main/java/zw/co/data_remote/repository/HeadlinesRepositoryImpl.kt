package zw.co.data_remote.repository

import kotlinx.coroutines.flow.Flow
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
): HeadlinesRemoteRepository {
    override suspend fun getHeadlines(): Flow<HeadlinesDataModel> {
        return remote.getHeadlines().map {
            mapper.mapFromEntity(it)
        }
    }

    override suspend fun getHeadlinesByCategory(category: String): Flow<HeadlinesDataModel> {
        return remote.getHeadlinesByCategory(category).map {
            mapper.mapFromEntity(it)
        }
    }
}