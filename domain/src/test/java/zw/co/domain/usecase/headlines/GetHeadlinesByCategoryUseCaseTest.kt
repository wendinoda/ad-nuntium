package zw.co.domain.usecase.headlines

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever
import zw.co.domain.HeadlinesDummyData
import zw.co.domain.HeadlinesDummyData.expected
import zw.co.domain.HeadlinesDummyData.headlines
import zw.co.domain.model.Articles
import zw.co.domain.model.Headlines
import zw.co.domain.model.SourceHeadline
import zw.co.domain.repository.HeadlinesRepository
import zw.co.test_module.TestCoroutineRule
import zw.co.test_module.buildDate

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class GetHeadlinesByCategoryUseCaseTest {

    private lateinit var getHeadlinesByCategoryUseCase: GetHeadlinesByCategoryUseCase

    @Mock
    lateinit var headlinesRepository: HeadlinesRepository

    @JvmField
    @Rule
    val mainCoroutineRule = TestCoroutineRule()

    @Before
    fun init() {
        getHeadlinesByCategoryUseCase = GetHeadlinesByCategoryUseCase(headlinesRepository)
    }

    @Test
    fun `When getHeadlinesByCategoryUseCase then returns expected Headlines`() {
        runBlocking {
            val headlines = flow { emit(headlines) }

            whenever(headlinesRepository.getHeadlinesByCategory(Mockito.anyString())).thenReturn(headlines)
            // When
            val actualValue = getHeadlinesByCategoryUseCase.execute(Mockito.anyString()).first()
            // Then
            Mockito.verify(headlinesRepository, Mockito.times(1)).getHeadlinesByCategory(Mockito.anyString())
            Assert.assertEquals(expected, actualValue)
        }
    }
}