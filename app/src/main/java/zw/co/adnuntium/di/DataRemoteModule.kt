package zw.co.adnuntium.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import zw.co.data.model.SourcesSuccessDataModel
import zw.co.data.repository.sources.SourcesRemoteRepository
import zw.co.data_remote.BuildConfig
import zw.co.data_remote.mapper.Mapper
import zw.co.data_remote.mapper.SourcesEntityMapper
import zw.co.data_remote.model.SourcesSuccessEntity
import zw.co.data_remote.network.RestService
import zw.co.data_remote.network.ServiceFactory
import zw.co.data_remote.repository.SourcesRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataRemoteModule {


    @ExperimentalSerializationApi
    @Provides
    @Singleton
    fun providesRestService(): RestService = ServiceFactory.makeService(BuildConfig.DEBUG)

    @Provides
    fun providesSourcesRemoteRepository(
        remoteService: RestService,
        sourcesMapper: SourcesEntityMapper,
    ): SourcesRemoteRepository = SourcesRepositoryImpl(
        remoteService,
        sourcesMapper
    )

    @Provides
    fun providesSourcesEntityMapper(): Mapper<SourcesSuccessEntity, SourcesSuccessDataModel> =
        SourcesEntityMapper()

}