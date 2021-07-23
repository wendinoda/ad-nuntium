package zw.co.data_remote.mapper

import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import zw.co.data.model.HeadlinesDataModel
import zw.co.data_remote.HeadlinesDummyData.headlinesArray1
import zw.co.data_remote.HeadlinesDummyData.headlinesArray2
import zw.co.data_remote.model.HeadlinesEntity

@RunWith(Parameterized::class)
class HeadlinesEntityMapperTest(
    private val given: HeadlinesEntity,
    private val expected: HeadlinesDataModel
) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                headlinesArray1,
                headlinesArray2
            )
        }
    }

    private lateinit var headlinesEntityMapper: HeadlinesEntityMapper
    private lateinit var dateFormatter: DateFormatter

    @Before
    fun init(){
        dateFormatter = DateFormatter()
        headlinesEntityMapper = HeadlinesEntityMapper(dateFormatter)
    }

    @Test
    fun `given HeadlinesEntity to HeadlinesDataModel Then returns expected result`(){
        val actualValue = headlinesEntityMapper.mapFromEntity(given)
        assertEquals(expected, actualValue)
    }
}