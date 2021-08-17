package zw.co.data.repository.repositoryImpl

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import zw.co.data.SourcesDummyData.getSourcesDataModel
import zw.co.data.mapper.SourcesDataMapper
import zw.co.data.model.SourceDataModel
import zw.co.data.model.SourcesSuccessDataModel
import zw.co.data.source.sources.SourcesDataStoreFactory
import zw.co.test_module.TestCoroutineRule

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class SourcesRepositoryImplTest {

    private lateinit var sourcesRepository: SourcesRepositoryImpl

    @JvmField
    @Rule
    val mainCoroutineRule = TestCoroutineRule()

    @Mock
    lateinit var factory: SourcesDataStoreFactory
    @Mock
    lateinit var mapper: SourcesDataMapper

    @Before
    fun init(){
        sourcesRepository = SourcesRepositoryImpl(factory, mapper)
    }

    @Test
    fun getSources() {
        runBlocking {
            whenever(mapper.mapFromEntity(getSourcesDataModel())).thenReturn(mock())
            whenever(factory.retrieveDataStore(Mockito.anyBoolean())).thenReturn(mock())
        }
    }
}