package zw.co.presentation.mapper

import zw.co.domain.model.Articles
import zw.co.domain.model.Headlines
import zw.co.domain.model.SourceHeadline
import zw.co.presentation.model.ArticlesView
import zw.co.presentation.model.HeadlinesView
import zw.co.presentation.model.SourceHeadlineView
import javax.inject.Inject

class HeadlinesMapper @Inject constructor() : Mapper<Headlines, HeadlinesView> {
    override fun mapToUi(type: Headlines) = HeadlinesView(
        status = type.status,
        totalResults = type.totalResults,
        articles = type.articles.map {
            mapToUi(it)
        }
    )

    fun mapToUi(type: Articles) = ArticlesView(
        title = type.title,
        description = type.description,
        author = type.author,
        content = type.content,
        url = type.url,
        urlToImage = type.urlToImage,
        publishedAt = type.publishedAt,
        source = mapToView(type.source)
    )

    private fun mapToView(type: SourceHeadline) = SourceHeadlineView(
        id = type.id,
        name = type.name
    )

    override fun mapToDomain(type: HeadlinesView): Headlines {
        TODO("Not yet implemented")
    }
}