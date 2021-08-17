package zw.co.adnuntium.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import zw.co.domain.model.Headlines
import zw.co.domain.model.News
import zw.co.domain.model.SourcesSuccess
import zw.co.domain.repository.HeadlinesRepository
import zw.co.domain.repository.NewsRepository
import zw.co.domain.repository.SourcesRepository
import zw.co.domain.usecase.DefaultUseCase
import zw.co.domain.usecase.DefaultUseCaseWithParams
import zw.co.domain.usecase.headlines.GetAllHeadlinesUseCase
import zw.co.domain.usecase.headlines.GetHeadlinesByCategoryUseCase
import zw.co.domain.usecase.news.GetNewsStoriesUseCase
import zw.co.domain.usecase.sources.GetAllSourcesUseCase

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {
    @Provides
    fun provideAllSourcesUseCase(
        repository: SourcesRepository
    ): DefaultUseCase<SourcesSuccess> = GetAllSourcesUseCase(
        repository = repository
    )

    @Provides
    fun providesGetHeadlines(
        repository: HeadlinesRepository
    ): DefaultUseCase<Headlines> = GetAllHeadlinesUseCase(
        repository = repository
    )

    @Provides
    fun providesGetHeadlinesByCategory(
        repository: HeadlinesRepository
    ): DefaultUseCaseWithParams<String, Headlines> = GetHeadlinesByCategoryUseCase(
        repository = repository
    )

    @Provides
    fun providesGetNewsStories(
        repository: NewsRepository
    ): DefaultUseCase<News> = GetNewsStoriesUseCase(
        repository = repository
    )
}