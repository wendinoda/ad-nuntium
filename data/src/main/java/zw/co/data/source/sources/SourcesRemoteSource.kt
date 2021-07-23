package zw.co.data.source.sources

import kotlinx.coroutines.flow.Flow
import zw.co.data.model.SourceDataModel
import zw.co.data.model.SourcesSuccessDataModel
import zw.co.data.repository.sources.SourcesRemoteRepository
import zw.co.data.repository.sources.SourcesRepository
import javax.inject.Inject

open class SourcesRemoteSource @Inject constructor(
    private val sourcesRemote: SourcesRemoteRepository
) : SourcesRepository {
    override suspend fun getSources(): Flow<SourcesSuccessDataModel> =
        sourcesRemote.getSources()

    override suspend fun clearSources() {
        throw  UnsupportedOperationException()
    }

    override suspend fun saveSources(sources: List<SourceDataModel>) {
        throw UnsupportedOperationException()
    }

    override suspend fun isCached(): Boolean {
        throw UnsupportedOperationException()
    }
}