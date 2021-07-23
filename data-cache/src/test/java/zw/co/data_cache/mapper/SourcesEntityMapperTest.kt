package zw.co.data_cache.mapper

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import zw.co.data.model.SourceDataModel
import zw.co.data_cache.model.SourceEntity

@RunWith(Parameterized::class)
class SourcesEntityMapperTest(
    private val given: SourceEntity,
    private val expected: SourceDataModel
) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                arrayOf(
                    SourceEntity(
                        id = "1",
                        name = "CNN",
                        description = "News",
                        url = "cnn.com",
                        category = "news",
                        language = "eng",
                        country = "us"
                    ),
                    SourceDataModel(
                        id = "1",
                        name = "CNN",
                        description = "News",
                        url = "cnn.com",
                        category = "news",
                        language = "eng",
                        country = "us"
                    )
                ),
                arrayOf(
                    SourceEntity(
                        id = "2",
                        name = "BBC",
                        description = "News",
                        url = "bbc.com",
                        category = "news",
                        language = "eng",
                        country = "uk"
                    ),
                    SourceDataModel(
                        id = "2",
                        name = "BBC",
                        description = "News",
                        url = "bbc.com",
                        category = "news",
                        language = "eng",
                        country = "uk"
                    )
                ),
            )
        }
    }

    private lateinit var sourcesEntityMapper: SourcesEntityMapper

    @Before
    fun init (){
        sourcesEntityMapper = SourcesEntityMapper()
    }

    @Test
    fun `given sourcesEntity to sourcesDataModel Then returns expected result`(){
        val actualValue = sourcesEntityMapper.mapFromCached(given)
        Assert.assertEquals(expected, actualValue)
    }

    @Test
    fun `given sourcesEntity from sourcesDataModel Then returns expected result`(){
        val actualValue = sourcesEntityMapper.mapToCached(expected)
        Assert.assertEquals(given, actualValue)
    }
}