package zw.co.data.repository.sources

import kotlinx.coroutines.flow.Flow
import zw.co.data.model.SourcesSuccessDataModel

interface SourcesRemoteRepository {
    suspend fun getSources(): Flow<SourcesSuccessDataModel>
}