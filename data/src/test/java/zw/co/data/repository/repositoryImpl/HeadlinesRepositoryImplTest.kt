package zw.co.data.repository.repositoryImpl

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever
import zw.co.data.mapper.HeadlinesDataMapper
import zw.co.data.source.headlines.HeadlinesDataStoreFactory
import zw.co.test_module.TestCoroutineRule

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class HeadlinesRepositoryImplTest {

    private lateinit var headlinesRepository: HeadlinesRepositoryImpl

    @JvmField
    @Rule
    val mainCoroutineRule = TestCoroutineRule()

    @Mock
    lateinit var factory: HeadlinesDataStoreFactory
    @Mock
    lateinit var mapper: HeadlinesDataMapper

    @Before
    fun init(){
        headlinesRepository = HeadlinesRepositoryImpl(factory, mapper)
    }

    @Test
    fun getAllHeadlines() {
    }

    @Test
    fun getHeadlinesByCategory() {
    }

    @Test
    fun clearHeadlines() {
    }

    @Test
    fun saveHeadlines() {
    }
}