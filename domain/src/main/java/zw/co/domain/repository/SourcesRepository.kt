package zw.co.domain.repository

import kotlinx.coroutines.flow.Flow
import zw.co.domain.model.Source
import zw.co.domain.model.SourcesSuccess

interface SourcesRepository {
    suspend fun getSources(): Flow<SourcesSuccess>

    suspend fun clearSources()

    suspend fun saveSources(sources: List<Source>)

    suspend fun getSourcesByCountry(
        country: String
    ): Flow<SourcesSuccess>

    suspend fun getSourcesByCategory(
        category: String
    ): Flow<SourcesSuccess>
}