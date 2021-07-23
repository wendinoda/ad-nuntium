package zw.co.data.source.cache

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
import zw.co.data.repository.sources.SourcesCacheRepository
import zw.co.data.source.sources.SourcesCacheSource
import zw.co.test_module.TestCoroutineRule

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class SourcesCacheSourceTest {

    private lateinit var sourceCache: SourcesCacheSource

    @Mock
    lateinit var sourceCacheRepository: SourcesCacheRepository

    @JvmField
    @Rule
    val mainCoroutineRule = TestCoroutineRule()

    @Before
    fun init(){
        sourceCache = SourcesCacheSource(sourceCacheRepository)
    }


    @Test
    fun ` when getSources then sourceCacheRepository is called`() {
        runBlocking {
            whenever(sourceCacheRepository.getSources()).thenReturn(mock())

            sourceCache.getSources()

            verify(sourceCacheRepository, times(1)).getSources()
        }
    }

    @Test
    fun `when clearSources then sourcesCacheRepository is called`() {
        runBlocking {
            whenever(sourceCacheRepository.clearSources()).thenReturn(Unit)

            sourceCache.clearSources()

            verify(sourceCacheRepository, times(1)).clearSources()
        }
    }

    @Test
    fun `when saveSources then sourcesCacheRepository is called`() {
        runBlocking {
            whenever(sourceCacheRepository.saveSources(Mockito.anyList())).thenReturn(Unit)

            sourceCache.saveSources(Mockito.anyList())

            verify(sourceCacheRepository, times(1)).saveSources(Mockito.anyList())
        }
    }

    @Test
    fun `when isCached then sourcesCacheRepository is called`() {
        runBlocking {
            whenever(sourceCacheRepository.isCached()).thenReturn(true)

            sourceCache.isCached()

            verify(sourceCacheRepository, times(1)).isCached()
        }
    }
}