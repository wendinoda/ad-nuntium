package zw.co.data.mapper

import zw.co.data.model.ArticlesDataModel
import zw.co.data.model.HeadlinesDataModel
import zw.co.data.model.SourceHeadlineDataModel
import zw.co.domain.model.Articles
import zw.co.domain.model.Headlines
import zw.co.domain.model.SourceHeadline
import javax.inject.Inject

class HeadlinesDataMapper @Inject constructor(): Mapper<HeadlinesDataModel, Headlines> {
    override fun mapFromEntity(type: HeadlinesDataModel) = Headlines(
        status = type.status,
        totalResults = type.totalResults,
        articles = type.articles.map {
            mapFromEntity(it)
        }
    )

    fun mapFromEntity(type: ArticlesDataModel) = Articles(
        title = type.title,
        description = type.description,
        author = type.author,
        content = type.content,
        url = type.url,
        urlToImage = type.urlToImage,
        publishedAt = type.publishedAt,
        source = mapFromEntity(type.source)
    )

    private fun mapFromEntity(type: SourceHeadlineDataModel) = SourceHeadline(
        id = type.id,
        name = type.name
    )

    fun mapToEntity(type: Articles) = ArticlesDataModel(
        title = type.title,
        description = type.description,
        author = type.author,
        content = type.content,
        url = type.url,
        urlToImage = type.urlToImage,
        publishedAt = type.publishedAt,
        source = mapToEntity(type.source)
    )

    private fun mapToEntity(type: SourceHeadline) = SourceHeadlineDataModel(
        id = type.id,
        name = type.name
    )

    override fun mapToEntity(type: Headlines): HeadlinesDataModel {
        TODO("Not yet implemented")
    }
}