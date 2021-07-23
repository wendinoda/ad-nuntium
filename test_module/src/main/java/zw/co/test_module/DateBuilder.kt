package zw.co.test_module

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

fun buildDate(dateValue: String): DateTime =
    DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ssZ")
        .parseDateTime(dateValue.replace("Z", "+00"))