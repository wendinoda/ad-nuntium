package zw.co.domain.usecase.headlines

import kotlinx.coroutines.flow.Flow
import zw.co.domain.model.Headlines
import zw.co.domain.repository.HeadlinesRepository
import zw.co.domain.usecase.DefaultUseCase
import javax.inject.Inject

class GetAllHeadlinesUseCase @Inject constructor(
    private val repository: HeadlinesRepository
): DefaultUseCase<Headlines> {
    override suspend fun execute(): Flow<Headlines> {
        return repository.getAllHeadlines()
    }
}