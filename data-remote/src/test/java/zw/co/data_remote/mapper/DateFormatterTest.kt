package zw.co.data_remote.mapper

import junit.framework.Assert.assertEquals
import org.joda.time.DateTime
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import zw.co.test_module.buildDate

@RunWith(Parameterized::class)
class DateFormatterTest(
    private val given: String,
    private val expected: DateTime
) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                arrayOf("2021-01-01T12:49:03Z", buildDate("2021-01-01T12:49:03Z")),
                arrayOf("2020-02-11T00:00:00Z", buildDate("2020-02-11T00:00:00Z")),
                arrayOf("2019-03-22T00:00:00Z", buildDate("2019-03-22T00:00:00Z")),
            )
        }
    }

    private lateinit var dateFormatter: DateFormatter

    @Before
    fun init() {
        dateFormatter = DateFormatter()
    }

    @Test
    fun `Given dateValue when format then returns expected result`() {
        val actual = dateFormatter.format(given)

        assertEquals(expected, actual)
    }
}