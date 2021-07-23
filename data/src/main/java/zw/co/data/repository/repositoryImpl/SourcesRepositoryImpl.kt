package zw.co.data.repository.repositoryImpl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.single
import zw.co.data.mapper.SourcesDataMapper
import zw.co.data.model.SourceDataModel
import zw.co.data.source.sources.SourcesDataStoreFactory
import zw.co.domain.model.Source
import zw.co.domain.model.SourcesSuccess
import zw.co.domain.repository.SourcesRepository
import javax.inject.Inject

class SourcesRepositoryImpl @Inject constructor(
    private val factory: SourcesDataStoreFactory,
    private val mapper: SourcesDataMapper
) : SourcesRepository {

    override suspend fun getSources(): Flow<SourcesSuccess> {
        return factory.retrieveDataStore(factory.retrieveCacheDataStore().isCached())
            .getSources().map {
                mapper.mapFromEntity(it)
            }.also {
                saveSources(it.first().sources)
            }
    }

    override suspend fun clearSources() {
        factory.retrieveCacheDataStore().clearSources()
    }

    override suspend fun saveSources(sources: List<Source>) {
        val sourcesDataModel = mutableListOf<SourceDataModel>()
        sources.map { sourcesDataModel.add(mapper.mapToEntity(it)) }
        factory.retrieveCacheDataStore().saveSources(sourcesDataModel)
    }

    override suspend fun getSourcesByCountry(country: String): Flow<SourcesSuccess> {
        TODO("Not yet implemented")
    }

    override suspend fun getSourcesByCategory(category: String): Flow<SourcesSuccess> {
        TODO("Not yet implemented")
    }
}