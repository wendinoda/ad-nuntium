package zw.co.data

import zw.co.data.model.HeadlinesDataModel
import zw.co.domain.model.Articles
import zw.co.domain.model.Headlines
import zw.co.domain.model.SourceHeadline
import zw.co.test_module.buildDate

object HeadlinesDummyData {
    val headlinesArray1 = arrayOf(
        HeadlinesDataModel(
            status = "ok",
            totalResults = 2,
            articles = ArticlesDummyData.articlesDataModel1,
        ),
        Headlines(
            status = "ok",
            totalResults = 2,
            articles = ArticlesDummyData.articles1,
        )
    )

    val headlinesArray2 = arrayOf(
        HeadlinesDataModel(
            status = "ok",
            totalResults = 2,
            articles = ArticlesDummyData.articlesDataModel2,
        ),
        Headlines(
            status = "ok",
            totalResults = 2,
            articles = ArticlesDummyData.articles2,
        )
    )
}