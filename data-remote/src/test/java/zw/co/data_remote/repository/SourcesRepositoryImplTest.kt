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
import zw.co.data_remote.mapper.SourcesEntityMapper
import zw.co.data_remote.model.SourcesSuccessEntity
import zw.co.data_remote.network.RestService
import zw.co.test_module.TestCoroutineRule

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class SourcesRepositoryImplTest {
    private lateinit var repository: SourcesRepositoryImpl
    @Mock
    lateinit var restService: RestService
    @Mock
    private lateinit var mapper: SourcesEntityMapper

    @JvmField
    @Rule
    val mainCoroutineRule = TestCoroutineRule()

    @Before
    fun init(){
        repository = SourcesRepositoryImpl(restService, mapper)
    }

    @Test
    fun `when getSources then restService called`(){
        runBlocking {
            whenever(restService.getSources()).thenReturn(mock())

            repository.getSources()

            verify(restService, times(1)).getSources()
        }
    }
}