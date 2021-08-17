package zw.co.data

import zw.co.data.ArticlesDummyData
import zw.co.data.model.HeadlinesDataModel
import zw.co.data.model.NewsDataModel
import zw.co.domain.model.Headlines
import zw.co.domain.model.News

object NewsDummyData {
    val newsArray1 = arrayOf(
        NewsDataModel(
            status = "ok",
            totalResults = 2,
            articles = ArticlesDummyData.articlesDataModel1,
        ),
        News(
            status = "ok",
            totalResults = 2,
            articles = ArticlesDummyData.articles1,
        )
    )

    val newsArray2 = arrayOf(
        NewsDataModel(
            status = "ok",
            totalResults = 2,
            articles = ArticlesDummyData.articlesDataModel2,
        ),
        News(
            status = "ok",
            totalResults = 2,
            articles = ArticlesDummyData.articles2,
        )
    )
}