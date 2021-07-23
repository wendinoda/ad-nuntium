package zw.co.data.repository.sources

import kotlinx.coroutines.flow.Flow
import zw.co.data.model.SourceDataModel
import zw.co.data.model.SourcesSuccessDataModel

interface SourcesRepository {
    suspend fun getSources(): Flow<SourcesSuccessDataModel>

    suspend fun clearSources()

    suspend fun saveSources(sources: List<SourceDataModel>)

    suspend fun isCached(): Boolean
}