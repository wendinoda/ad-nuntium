package zw.co.data.mapper

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import zw.co.data.model.NewsDataModel
import zw.co.data.NewsDummyData
import zw.co.domain.model.News

@RunWith(Parameterized::class)
class NewsDataMapperTest(
    private val given: NewsDataModel,
    private val expected: News
) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>>{
            return listOf(
                NewsDummyData.newsArray1,
                NewsDummyData.newsArray2
            )
        }
    }
    private lateinit var mapper: NewsDataMapper

    @Before
    fun init(){
        mapper = NewsDataMapper(HeadlinesDataMapper())
    }

    @Test
    fun `given NewsDataModel to News then return expected result`(){
        val actualValue = mapper.mapFromEntity(given)
        assertEquals(expected, actualValue)
    }
}