package zw.co.data

import zw.co.data.model.SourceDataModel
import zw.co.data.model.SourcesSuccessDataModel
import zw.co.domain.model.Source
import zw.co.domain.model.SourcesSuccess

object SourcesDummyData {
    val sourcesArray1 = arrayOf(
        SourcesSuccessDataModel(
            status = "ok",
            sources = listOf(
                SourceDataModel(
                    id = "2",
                    name = "BBC",
                    description = "News",
                    url = "bbc.com",
                    category = "news",
                    language = "eng",
                    country = "us"
                ),
                SourceDataModel(
                    id = "5",
                    name = "Aljazeera",
                    description = "News",
                    url = "aljazeera.com",
                    category = "news",
                    language = "eng",
                    country = "qa"
                )
            )
        ),
        SourcesSuccess(
            status = "ok",
            sources = listOf(
                Source(
                    id = "2",
                    name = "BBC",
                    description = "News",
                    url = "bbc.com",
                    category = "news",
                    language = "eng",
                    country = "us"
                ),
                Source(
                    id = "5",
                    name = "Aljazeera",
                    description = "News",
                    url = "aljazeera.com",
                    category = "news",
                    language = "eng",
                    country = "qa"
                )
            )
        )
    )
    val sourcesArray2 = arrayOf(
        SourcesSuccessDataModel(
            status = "ok",
            sources = listOf(
                SourceDataModel(
                    id = "1",
                    name = "CNN",
                    description = "News",
                    url = "cnn.com",
                    category = "news",
                    language = "eng",
                    country = "us"
                ),
                SourceDataModel(
                    id = "4",
                    name = "the verge",
                    description = "News",
                    url = "theverge.com",
                    category = "tech",
                    language = "eng",
                    country = "us"
                )
            )
        ),
        SourcesSuccess(
            status = "ok",
            sources = listOf(
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
                    id = "4",
                    name = "the verge",
                    description = "News",
                    url = "theverge.com",
                    category = "tech",
                    language = "eng",
                    country = "us"
                )
            )
        )
    )

    fun getSourcesDataModel(): SourcesSuccessDataModel =
        SourcesSuccessDataModel(
            status = "ok",
            sources = listOf(
                SourceDataModel(
                    id = "1",
                    name = "CNN",
                    description = "News",
                    url = "cnn.com",
                    category = "news",
                    language = "eng",
                    country = "us"
                )
            )
        )
}