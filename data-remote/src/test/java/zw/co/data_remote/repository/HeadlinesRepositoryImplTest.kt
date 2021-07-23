package zw.co.data_remote.repository

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import zw.co.data_remote.mapper.DateFormatter
import zw.co.data_remote.mapper.HeadlinesEntityMapper
import zw.co.data_remote.network.RestService
import zw.co.test_module.TestCoroutineRule

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class HeadlinesRepositoryImplTest {

    private lateinit var mapper: HeadlinesEntityMapper
    private lateinit var repository: HeadlinesRepositoryImpl

    @Mock
    lateinit var restService: RestService

    @JvmField
    @Rule
    val mainCoroutineRule = TestCoroutineRule()

    @Before
    fun init() {
        mapper = HeadlinesEntityMapper(DateFormatter())
        repository = HeadlinesRepositoryImpl(restService, mapper)
    }

    @Test
    fun `when getHeadlines then restService called`() {
        runBlocking {
            whenever(restService.getHeadlines()).thenReturn(mock())

            repository.getHeadlines()

            verify(restService, times(1)).getHeadlines()
        }
    }

    @Test
    fun `when getHeadlinesByCategory then restService called`() {
        runBlocking {
            whenever(
                restService.getHeadlinesByCategory(
                    ""
                )
            ).thenReturn(mock())

            repository.getHeadlinesByCategory("")

            verify(restService, times(1)).getHeadlinesByCategory(
                ""
            )
        }
    }
}