package zw.co.data.mapper

import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import zw.co.data.HeadlinesDummyData.headlinesArray1
import zw.co.data.HeadlinesDummyData.headlinesArray2
import zw.co.data.model.HeadlinesDataModel
import zw.co.domain.model.Headlines

@RunWith(Parameterized::class)
class HeadlinesDataMapperTest(
    private val given: HeadlinesDataModel,
    private val expected: Headlines
) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>>{
            return listOf(
                headlinesArray1,
                headlinesArray2
            )
        }
    }

    private lateinit var mapper: HeadlinesDataMapper

    @Before
    fun init(){
        mapper = HeadlinesDataMapper()
    }

    @Test
    fun `given HeadlinesDataModel to Headlines then return expected result`(){
        val actualValue = mapper.mapFromEntity(given)
        assertEquals(expected, actualValue)
    }
}