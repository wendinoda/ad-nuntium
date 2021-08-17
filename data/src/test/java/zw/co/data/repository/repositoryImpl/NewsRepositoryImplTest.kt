package zw.co.data.repository.repositoryImpl

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import zw.co.data.mapper.HeadlinesDataMapper
import zw.co.data.mapper.NewsDataMapper
import zw.co.data.source.news.NewsDataStoreFactory
import zw.co.test_module.TestCoroutineRule

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class NewsRepositoryImplTest {
    private lateinit var repository: NewsRepositoryImpl

    @Mock
    lateinit var factory: NewsDataStoreFactory
    @Mock
    lateinit var newsMapper: NewsDataMapper
    @Mock
    lateinit var headlinesMapper: HeadlinesDataMapper

    @JvmField
    @Rule
    val mainCoroutineRule = TestCoroutineRule()

    @Before
    fun init(){
        repository = NewsRepositoryImpl(factory, newsMapper, headlinesMapper)
    }

    @Test
    fun getNewsStories(){
        runBlocking {
            whenever(factory.retrieveDataStore(true)).thenReturn(mock())
        }
    }
}