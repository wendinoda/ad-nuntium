package zw.co.adnuntium.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import zw.co.data.mapper.Mapper
import zw.co.data.mapper.SourcesDataMapper
import zw.co.data.model.SourcesSuccessDataModel
import zw.co.data.repository.sources.SourcesCacheRepository
import zw.co.data.repository.sources.SourcesRemoteRepository
import zw.co.data.repository.repositoryImpl.SourcesRepositoryImpl
import zw.co.data.source.sources.SourcesCacheSource
import zw.co.data.source.sources.SourcesDataStoreFactory
import zw.co.data.source.sources.SourcesRemoteSource
import zw.co.domain.model.SourcesSuccess
import zw.co.domain.repository.SourcesRepository

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    fun providesSourcesRepository(
        factory: SourcesDataStoreFactory,
        mapper: SourcesDataMapper
    ): SourcesRepository = SourcesRepositoryImpl(
        factory, mapper
    )

    @Provides
    fun providesSourcesCacheSource(
        sourcesCache: SourcesCacheRepository
    ): zw.co.data.repository.sources.SourcesRepository = SourcesCacheSource(
        sourcesCache
    )

    @Provides
    fun providesSourcesRemoteSource(
        sourcesRemote: SourcesRemoteRepository
    ): zw.co.data.repository.sources.SourcesRepository = SourcesRemoteSource(
        sourcesRemote
    )

    @Provides
    fun providesSourcesDataMapper(): Mapper<SourcesSuccessDataModel, SourcesSuccess> =
        SourcesDataMapper()
}