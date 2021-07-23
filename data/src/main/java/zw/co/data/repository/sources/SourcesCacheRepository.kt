package zw.co.data.repository.sources

import kotlinx.coroutines.flow.Flow
import zw.co.data.model.SourceDataModel

interface SourcesCacheRepository {
    suspend fun clearSources()

    suspend fun saveSources(sources: List<SourceDataModel>)

    suspend fun getSources(): Flow<List<SourceDataModel>>

    suspend fun isCached(): Boolean

    fun setLastCacheTime(lastCache: Long)

    fun isExpired(): Boolean
}