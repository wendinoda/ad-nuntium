package zw.co.adnuntium.utils

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat
import javax.inject.Inject

object DateFormatter {
    private val dateTimeFormatter = DateTimeFormat.forPattern("MM-dd'T'HH:mm")

    fun toString(date: DateTime): String {
        return dateTimeFormatter.print(date)
    }
}