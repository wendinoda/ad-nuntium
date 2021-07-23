package zw.co.domain.usecase.headlines

import kotlinx.coroutines.flow.Flow
import zw.co.domain.model.Headlines
import zw.co.domain.repository.HeadlinesRepository
import zw.co.domain.usecase.DefaultUseCaseWithParams
import javax.inject.Inject

class GetHeadlinesByCategoryUseCase @Inject constructor(
    private val repository: HeadlinesRepository
) : DefaultUseCaseWithParams<String, Headlines> {

    override suspend fun execute(params: String): Flow<Headlines> {
        return repository.getHeadlinesByCategory(
            params
        )
    }
}