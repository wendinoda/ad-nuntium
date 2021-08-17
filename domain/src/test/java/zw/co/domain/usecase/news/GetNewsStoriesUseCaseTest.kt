package zw.co.domain.usecase.news

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
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import zw.co.domain.HeadlinesDummyData
import zw.co.domain.NewsDummyData
import zw.co.domain.repository.NewsRepository
import zw.co.test_module.TestCoroutineRule

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class GetNewsStoriesUseCaseTest {

    private lateinit var getNewsStoriesUseCase: GetNewsStoriesUseCase

    @Mock
    lateinit var repository: NewsRepository

    @JvmField
    @Rule
    val mainCoroutineRule = TestCoroutineRule()

    @Before
    fun init(){
        getNewsStoriesUseCase = GetNewsStoriesUseCase(repository)
    }

    @Test
    fun `When getNewsStoriesUseCase then returns expected News`(){
        runBlocking {
            val news = flow { emit(NewsDummyData.expected) }

            whenever(repository.getNewsStories()).thenReturn(news)

            val actualValue = getNewsStoriesUseCase.execute().first()

            Mockito.verify(repository, Mockito.times(1)).getNewsStories()
            Assert.assertEquals(NewsDummyData.expected, actualValue)
        }
    }
}