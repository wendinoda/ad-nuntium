package zw.co.data_remote.mapper

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import javax.inject.Inject

class DateFormatter @Inject constructor() {
    fun format(dateValue: String): DateTime {
        val dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ssZ")
        return dateTimeFormatter.parseDateTime(dateValue.replace("Z", "+00"))
    }
}