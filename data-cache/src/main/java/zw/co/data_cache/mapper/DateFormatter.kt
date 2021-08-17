package zw.co.data_cache.mapper

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import javax.inject.Inject

class DateFormatter @Inject constructor() {
    private val dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ssZ")

    fun format(dateValue: String): DateTime {
        return dateTimeFormatter.parseDateTime(dateValue.replace("Z", "+00"))
    }

    fun toString(date: DateTime): String {
        return dateTimeFormatter.print(date)
    }
}