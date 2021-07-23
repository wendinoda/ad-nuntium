package zw.co.domain.usecase.headlines

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
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever
import zw.co.domain.HeadlinesDummyData.expected
import zw.co.domain.HeadlinesDummyData.headlines
import zw.co.domain.repository.HeadlinesRepository
import zw.co.test_module.TestCoroutineRule

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class GetAllHeadlinesUseCaseTest{
    private lateinit var getAllHeadlinesUseCase: GetAllHeadlinesUseCase
    @Mock
    lateinit var headlinesRepository: HeadlinesRepository

    @JvmField
    @Rule
    val mainCoroutineRule = TestCoroutineRule()

    @Before
    fun init() {
        getAllHeadlinesUseCase = GetAllHeadlinesUseCase(headlinesRepository)
    }

    @Test
    fun `When getAllHeadlinesUseCase then returns expected Headlines`(){
        runBlocking {
            val headlines = flow { emit(headlines) }

            whenever(headlinesRepository.getAllHeadlines()).thenReturn(headlines)
            // When
            val actualValue = getAllHeadlinesUseCase.execute().first()
            // Then
            Mockito.verify(headlinesRepository, Mockito.times(1)).getAllHeadlines()
            assertEquals(expected, actualValue)
        }
    }
}