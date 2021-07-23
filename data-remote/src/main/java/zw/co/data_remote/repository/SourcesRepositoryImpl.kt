package zw.co.data_remote.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import zw.co.data.model.SourcesSuccessDataModel
import zw.co.data.repository.sources.SourcesRemoteRepository
import zw.co.data_remote.BuildConfig
import zw.co.data_remote.mapper.SourcesEntityMapper
import zw.co.data_remote.network.RestService
import javax.inject.Inject

class SourcesRepositoryImpl @Inject constructor(
    private val remote: RestService,
    private val mapper: SourcesEntityMapper,
): SourcesRemoteRepository {
    override suspend fun getSources(): Flow<SourcesSuccessDataModel> {
            return remote.getSources().map {
                mapper.mapFromEntity(it)
            }
    }
}