package zw.co.domain.usecase

import kotlinx.coroutines.flow.Flow

interface DefaultUseCase<T> {
    suspend fun execute(): Flow<T>
}

interface DefaultUseCaseWithParams<in N, out M> {
    suspend fun execute(params: N): Flow<M>
}
