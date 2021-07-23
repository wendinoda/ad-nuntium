package zw.co.domain

import zw.co.domain.model.Source
import zw.co.domain.model.SourcesSuccess

object SourcesDummyData {
    private val sourcesList = listOf(
        Source(
            id = "1",
            name = "CNN",
            description = "News",
            url = "cnn.com",
            category = "news",
            language = "eng",
            country = "us"
        ),
        Source(
            id = "1",
            name = "BBC",
            description = "News",
            url = "bbc.com",
            category = "news",
            language = "eng",
            country = "uk"
        )
    )
    val sourcesSuccess = SourcesSuccess(
        status = "ok",
        sources = sourcesList
    )

    private val expectedSourcesList = listOf(
        Source(
            id = "1",
            name = "CNN",
            description = "News",
            url = "cnn.com",
            category = "news",
            language = "eng",
            country = "us"
        ),
        Source(
            id = "1",
            name = "BBC",
            description = "News",
            url = "bbc.com",
            category = "news",
            language = "eng",
            country = "uk"
        )
    )

    val expected = SourcesSuccess(
        status = "ok",
        sources = expectedSourcesList
    )

}