package zw.co.data.source.remote

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import zw.co.data.repository.sources.SourcesRemoteRepository
import zw.co.data.source.sources.SourcesRemoteSource
import zw.co.test_module.TestCoroutineRule

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class SourcesRemoteSourceTest {

    private lateinit var sourcesRemote: SourcesRemoteSource

    @JvmField
    @Rule
    val mainCoroutineRule = TestCoroutineRule()

    @Mock
    lateinit var sourcesRemoteRepository: SourcesRemoteRepository

    @Before
    fun init(){
        sourcesRemote = SourcesRemoteSource(sourcesRemoteRepository)
    }

    @Test
    fun `when getSources the sourcesRemoteRepository is invoked`() {
        runBlocking {
            whenever(sourcesRemoteRepository.getSources()).thenReturn(mock())

            sourcesRemote.getSources()

            verify(sourcesRemoteRepository, times(1)).getSources()
        }
    }
}
