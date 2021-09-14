package zw.co.adnuntium.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import zw.co.data.mapper.HeadlinesDataMapper
import zw.co.data.mapper.Mapper
import zw.co.data.mapper.NewsDataMapper
import zw.co.data.mapper.SourcesDataMapper
import zw.co.data.model.HeadlinesDataModel
import zw.co.data.model.NewsDataModel
import zw.co.data.model.SourcesSuccessDataModel
import zw.co.data.repository.headlines.HeadlinesCacheRepository
import zw.co.data.repository.headlines.HeadlinesRemoteRepository
import zw.co.data.repository.news.NewsRemoteRepository
import zw.co.data.repository.repositoryImpl.HeadlinesRepositoryImpl
import zw.co.data.repository.repositoryImpl.NewsRepositoryImpl
import zw.co.data.repository.repositoryImpl.SourcesRepositoryImpl
import zw.co.data.repository.sources.SourcesCacheRepository
import zw.co.data.repository.sources.SourcesRemoteRepository
import zw.co.data.source.headlines.HeadlinesCacheSource
import zw.co.data.source.headlines.HeadlinesDataStoreFactory
import zw.co.data.source.headlines.HeadlinesRemoteSource
import zw.co.data.source.news.NewsDataStoreFactory
import zw.co.data.source.news.NewsRemoteSource
import zw.co.data.source.sources.SourcesCacheSource
import zw.co.data.source.sources.SourcesDataStoreFactory
import zw.co.data.source.sources.SourcesRemoteSource
import zw.co.domain.model.Headlines
import zw.co.domain.model.News
import zw.co.domain.model.SourcesSuccess
import zw.co.domain.repository.HeadlinesRepository
import zw.co.domain.repository.NewsRepository
import zw.co.domain.repository.SourcesRepository
import zw.co.presentation.mapper.HeadlinesMapper
import zw.co.presentation.mapper.NewsMapper

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
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

    @Provides
    fun providesHeadlinesRepository(
        factory: HeadlinesDataStoreFactory,
        mapper: HeadlinesDataMapper
    ): HeadlinesRepository = HeadlinesRepositoryImpl(
        factory, mapper
    )

    @Provides
    fun providesHeadlinesCacheSource(
        headlinesCache: HeadlinesCacheRepository
    ): zw.co.data.repository.headlines.HeadlinesRepository = HeadlinesCacheSource(
        headlinesCache
    )

    @Provides
    fun providesHeadlinesRemoteSource(
        headlinesRemote: HeadlinesRemoteRepository
    ): zw.co.data.repository.headlines.HeadlinesRepository = HeadlinesRemoteSource(
        headlinesRemote
    )

    @Provides
    fun providesHeadlinesDataMapper(): Mapper<HeadlinesDataModel, Headlines> =
        HeadlinesDataMapper()

    @Provides
    fun providesNewsDataMapper(
        mapper: HeadlinesDataMapper
    ): Mapper<NewsDataModel, News> = NewsDataMapper(mapper)

    @Provides
    fun providesNewsRepository(
        factory: NewsDataStoreFactory,
        mapper: NewsDataMapper,
        //headlinesMapper: HeadlinesDataMapper
    ): NewsRepository = NewsRepositoryImpl(
        factory, mapper, //headlinesMapper
    )

    @Provides
    fun providesNesRemoteSource(
        newsRemote: NewsRemoteRepository
    ): zw.co.data.repository.news.NewsRepository = NewsRemoteSource(
        newsRemote
    )
}
