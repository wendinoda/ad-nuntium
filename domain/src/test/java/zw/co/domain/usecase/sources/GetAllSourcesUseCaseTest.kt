package zw.co.domain.usecase.sources

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever
import zw.co.domain.SourcesDummyData.expected
import zw.co.domain.SourcesDummyData.sourcesSuccess
import zw.co.domain.model.Source
import zw.co.domain.model.SourcesSuccess
import zw.co.domain.repository.SourcesRepository
import zw.co.domain.usecase.sources.GetAllSourcesUseCase
import zw.co.test_module.TestCoroutineRule

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class GetAllSourcesUseCaseTest {
    private lateinit var getAllSourcesUseCase: GetAllSourcesUseCase

    @Mock
    lateinit var sourcesRepository: SourcesRepository

    @JvmField
    @Rule
    val mainCoroutineRule = TestCoroutineRule()

    @Before
    fun init() {
        getAllSourcesUseCase = GetAllSourcesUseCase(sourcesRepository)
    }

    @Test
    fun `When getAllSources then returns expected SourcesSuccess`(){
        runBlocking {

            val sources = flow { emit(sourcesSuccess) }

            whenever(sourcesRepository.getSources()).thenReturn(sources)
            // When
            val actualValue = getAllSourcesUseCase.execute().first()
            // Then
            verify(sourcesRepository, times(1)).getSources()
            assertEquals(expected, actualValue)
        }
    }
}