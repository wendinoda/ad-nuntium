package zw.co.data_remote.mapper

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import zw.co.data.model.SourceDataModel
import zw.co.data.model.SourcesSuccessDataModel
import zw.co.data_remote.SourcesDummyData.sourcesArray1
import zw.co.data_remote.SourcesDummyData.sourcesArray2
import zw.co.data_remote.model.SourceEntity
import zw.co.data_remote.model.SourcesSuccessEntity

@RunWith(Parameterized::class)
class SourcesEntityMapperTest(
    private val given: SourcesSuccessEntity,
    private val expected: SourcesSuccessDataModel
) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                sourcesArray1,
                sourcesArray2
            )
        }
    }

    private lateinit var sourcesEntityMapper: SourcesEntityMapper

    @Before
    fun init (){
        sourcesEntityMapper = SourcesEntityMapper()
    }

    @Test
    fun `given sourcesSuccessEntity to sourcesSuccessDataModel Then returns expected result`(){
        val actualValue = sourcesEntityMapper.mapFromEntity(given)
        assertEquals(expected, actualValue)
    }
}