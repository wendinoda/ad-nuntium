package zw.co.data_remote.mapper

import zw.co.data.model.ArticlesDataModel
import zw.co.data.model.HeadlinesDataModel
import zw.co.data.model.SourceHeadlineDataModel
import zw.co.data_remote.model.ArticlesEntity
import zw.co.data_remote.model.HeadlinesEntity
import zw.co.data_remote.model.SourceHeadlineEntity
import javax.inject.Inject

class HeadlinesEntityMapper @Inject constructor(
    private val dateFormatter: DateFormatter
): Mapper<HeadlinesEntity, HeadlinesDataModel> {
    override fun mapFromEntity(type: HeadlinesEntity) = HeadlinesDataModel(
        status = type.status,
        totalResults = type.totalResults,
        articles = type.articles.map { mapFromEntity(it) }
    )

    fun mapFromEntity(type: ArticlesEntity) = ArticlesDataModel(
        title = type.title,
        description = type.description,
        author = type.author,
        content = type.content,
        url = type.url,
        urlToImage = type.urlToImage,
        publishedAt = dateFormatter.format(type.publishedAt),
        source = mapFromEntity(type.source),
    )

    private fun mapFromEntity(type: SourceHeadlineEntity) = SourceHeadlineDataModel(
        id = type.id,
        name = type.name
    )
}