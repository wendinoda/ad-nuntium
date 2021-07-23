package zw.co.domain.usecase.sources

import kotlinx.coroutines.flow.Flow
import zw.co.domain.model.SourcesSuccess
import zw.co.domain.repository.SourcesRepository
import zw.co.domain.usecase.DefaultUseCase
import javax.inject.Inject

class GetAllSourcesUseCase @Inject constructor(
    private val repository: SourcesRepository
): DefaultUseCase<SourcesSuccess> {
    override suspend fun execute(): Flow<SourcesSuccess> {
        return repository.getSources()
    }
}