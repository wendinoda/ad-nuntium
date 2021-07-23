package zw.co.data.mapper

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import zw.co.data.SourcesDummyData.sourcesArray1
import zw.co.data.SourcesDummyData.sourcesArray2
import zw.co.data.model.SourceDataModel
import zw.co.data.model.SourcesSuccessDataModel
import zw.co.domain.model.Source
import zw.co.domain.model.SourcesSuccess

@RunWith(Parameterized::class)
class SourcesDataMapperTest constructor(
    private val given: SourcesSuccessDataModel,
    private val expected: SourcesSuccess
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

    private lateinit var mapper: SourcesDataMapper

    @Before
    fun init(){
        mapper = SourcesDataMapper()
    }

    @Test
    fun `given sourcesSuccessData to sourcesSuccess then return expected result`(){
        val actualValue = mapper.mapFromEntity(given)
        assertEquals(expected, actualValue)
    }
}