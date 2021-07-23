package zw.co.data_remote

import zw.co.data.model.SourceDataModel
import zw.co.data.model.SourcesSuccessDataModel
import zw.co.data_remote.model.SourceEntity
import zw.co.data_remote.model.SourcesSuccessEntity

object SourcesDummyData {
    val sourcesArray1 = arrayOf(
        SourcesSuccessEntity(
            status = "ok",
            sources = listOf(
                SourceEntity(
                    id = "1",
                    name = "CNN",
                    description = "News",
                    url = "cnn.com",
                    category = "news",
                    language = "eng",
                    country = "us"
                ),
                SourceEntity(
                    id = "2",
                    name = "BBC",
                    description = "News",
                    url = "bbc.com",
                    category = "news",
                    language = "eng",
                    country = "uk"
                )
            )
        ),
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
                    id = "2",
                    name = "BBC",
                    description = "News",
                    url = "bbc.com",
                    category = "news",
                    language = "eng",
                    country = "uk"
                )
            )
        )
    )

    val sourcesArray2 = arrayOf(
        SourcesSuccessEntity(
            status = "ok",
            sources = listOf(
                SourceEntity(
                    id = "3",
                    name = "ESPN",
                    description = "Sports",
                    url = "espn.com",
                    category = "sports",
                    language = "eng",
                    country = "us"
                ),
                SourceEntity(
                    id = "4",
                    name = "The Verge",
                    description = "News",
                    url = "theverge.com",
                    category = "tech",
                    language = "eng",
                    country = "us"
                )
            )
        ),
        SourcesSuccessDataModel(
            status = "ok",
            sources = listOf(
                SourceDataModel(
                    id = "3",
                    name = "ESPN",
                    description = "Sports",
                    url = "espn.com",
                    category = "sports",
                    language = "eng",
                    country = "us"
                ),
                SourceDataModel(
                    id = "4",
                    name = "The Verge",
                    description = "News",
                    url = "theverge.com",
                    category = "tech",
                    language = "eng",
                    country = "us"
                )
            )
        )
    )
}