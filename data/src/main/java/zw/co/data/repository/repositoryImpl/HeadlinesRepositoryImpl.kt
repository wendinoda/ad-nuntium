package zw.co.data.repository.repositoryImpl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import zw.co.data.mapper.HeadlinesDataMapper
import zw.co.data.model.ArticlesDataModel
import zw.co.data.source.headlines.HeadlinesDataStoreFactory
import zw.co.domain.model.Articles
import zw.co.domain.model.Headlines
import zw.co.domain.repository.HeadlinesRepository
import javax.inject.Inject

class HeadlinesRepositoryImpl @Inject constructor(
    private val factory: HeadlinesDataStoreFactory,
    private val mapper: HeadlinesDataMapper
) : HeadlinesRepository {
    override suspend fun getAllHeadlines(): Flow<Headlines> {
        return factory.retrieveDataStore(factory.retrieveCacheDataStore().isCached())
            .getHeadlines().map {
                mapper.mapFromEntity(it)
            }.also {
                saveHeadlines(it.first().articles)
            }
    }

    override suspend fun getHeadlinesByCategory(category: String): Flow<Headlines> {
        return factory.retrieveDataStore(factory.retrieveCacheDataStore().isCached())
            .getHeadlinesByCategory(category).map {
                mapper.mapFromEntity(it)
            }
    }

    override suspend fun clearHeadlines() {
        factory.retrieveCacheDataStore().clearHeadlines()
    }

    override suspend fun saveHeadlines(headlines: List<Articles>) {
        val headlinesDataModel = mutableListOf<ArticlesDataModel>()
        headlines.map { headlinesDataModel.add(mapper.mapToEntity(it)) }
    }
}