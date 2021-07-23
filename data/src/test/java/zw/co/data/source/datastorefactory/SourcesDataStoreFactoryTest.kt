package zw.co.data.source.datastorefactory

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever
import zw.co.data.repository.sources.SourcesCacheRepository
import zw.co.data.source.sources.SourcesCacheSource
import zw.co.data.source.sources.SourcesDataStoreFactory
import zw.co.data.source.sources.SourcesRemoteSource
import zw.co.test_module.TestCoroutineRule

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class SourcesDataStoreFactoryTest {

    private lateinit var sourceDataStore: SourcesDataStoreFactory

    @JvmField
    @Rule
    val mainCoroutineRule = TestCoroutineRule()

    @Mock
    lateinit var sourcesCache: SourcesCacheRepository

    @Mock
    lateinit var sourcesCacheSource: SourcesCacheSource

    @Mock
    lateinit var sourcesRemoteSource: SourcesRemoteSource

    @Before
    fun init() {
        sourceDataStore = SourcesDataStoreFactory(
            sourcesCache,
            sourcesCacheSource,
            sourcesRemoteSource
        )
    }

    @Test
    fun `when retrieveDataStore the return SourcesRemoteSource when is not cached`() {
        runBlocking {
            val data = sourceDataStore.retrieveDataStore(false)
            assert(data is SourcesRemoteSource)
        }
    }

    @Test
    fun `when retrieveDataStore the return SourcesCacheSource when is cached`() {
        runBlocking {
            stubSourcesCacheIsExpired(false)
            val data = sourceDataStore.retrieveDataStore(true)
            assert(data is SourcesCacheSource)
        }
    }

    @Test
    fun `when retrieveDataStore the return SourcesCacheSource when cache has expired`() {
        runBlocking {
            stubSourcesCacheIsExpired(true)
            val data = sourceDataStore.retrieveDataStore(true)
            assert(data is SourcesRemoteSource)
        }
    }

    @Test
    fun retrieveRemoteDataStore() {
        runBlocking {
            val data = sourceDataStore.retrieveRemoteDataStore()
            assert(data is SourcesRemoteSource)
        }
    }

    @Test
    fun retrieveCacheDataStore() {
        runBlocking {
            val data = sourceDataStore.retrieveCacheDataStore()
            assert(data is SourcesCacheSource)
        }
    }

    private fun stubSourcesCacheIsExpired(isExpired: Boolean) {
        whenever(sourcesCache.isExpired()).thenReturn(isExpired)
    }
}