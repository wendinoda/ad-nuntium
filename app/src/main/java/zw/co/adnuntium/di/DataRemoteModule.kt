package zw.co.adnuntium.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import zw.co.data.model.HeadlinesDataModel
import zw.co.data.model.NewsDataModel
import zw.co.data.model.SourcesSuccessDataModel
import zw.co.data.repository.headlines.HeadlinesRemoteRepository
import zw.co.data.repository.news.NewsRemoteRepository
import zw.co.data.repository.sources.SourcesRemoteRepository
import zw.co.data_remote.BuildConfig
import zw.co.data_remote.mapper.*
import zw.co.data_remote.model.HeadlinesEntity
import zw.co.data_remote.model.NewsEntity
import zw.co.data_remote.model.SourcesSuccessEntity
import zw.co.data_remote.network.RestService
import zw.co.data_remote.network.ServiceFactory
import zw.co.data_remote.repository.HeadlinesRepositoryImpl
import zw.co.data_remote.repository.NewsRepositoryImpl
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

    @Provides
    fun providesHeadlinesRemoteRepository(
        remoteService: RestService,
        headlinesMapper: HeadlinesEntityMapper,
    ): HeadlinesRemoteRepository = HeadlinesRepositoryImpl(
        remoteService,
        headlinesMapper
    )

    @Provides
    fun providesHeadlinesEntityMapper(
        dateFormatter: DateFormatter
    ): Mapper<HeadlinesEntity, HeadlinesDataModel> =
        HeadlinesEntityMapper(dateFormatter)

    @Provides
    fun provideNewsRemoteRepository(
        remoteService: RestService,
        newsMapper: NewsEntityMapper
    ): NewsRemoteRepository = NewsRepositoryImpl(
        remoteService,
        newsMapper
    )

    @Provides
    fun providesNewsEntityMapper(
        headlinesMapper: HeadlinesEntityMapper
    ): Mapper<NewsEntity, NewsDataModel> =
        NewsEntityMapper(headlinesMapper)
}