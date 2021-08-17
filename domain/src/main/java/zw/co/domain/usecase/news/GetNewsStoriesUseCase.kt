package zw.co.domain.usecase.news

import kotlinx.coroutines.flow.Flow
import zw.co.domain.model.News
import zw.co.domain.repository.NewsRepository
import zw.co.domain.usecase.DefaultUseCase
import javax.inject.Inject

class GetNewsStoriesUseCase @Inject constructor(
    private val repository: NewsRepository
): DefaultUseCase<News> {
    override suspend fun execute(): Flow<News> {
        return repository.getNewsStories()
    }
}