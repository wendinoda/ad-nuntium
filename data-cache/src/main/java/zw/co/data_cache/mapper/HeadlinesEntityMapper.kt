package zw.co.data_cache.mapper

import zw.co.data.model.ArticlesDataModel
import zw.co.data.model.SourceHeadlineDataModel
import zw.co.data_cache.model.HeadlineArticlesEntity
import zw.co.data_cache.model.SourceHeadlineEntity
import javax.inject.Inject

class HeadlinesEntityMapper @Inject constructor() :
    Mapper<HeadlineArticlesEntity, ArticlesDataModel> {
    override fun mapFromCached(type: HeadlineArticlesEntity) = ArticlesDataModel(
        author = type.author,
        title = type.title,
        description = type.description,
        url = type.url,
        urlToImage = type.urlToImage,
        publishedAt = type.publishedAt,
        content = type.content,
        source = mapToCached(type.source)
    )

    private fun mapToCached(type: SourceHeadlineEntity) = SourceHeadlineDataModel(
        id = type.id,
        name = type.name
    )

    override fun mapToCached(type: ArticlesDataModel) = HeadlineArticlesEntity(
        author = type.author,
        title = type.title,
        description = type.description,
        urlToImage = type.urlToImage,
        url = type.url,
        publishedAt = type.publishedAt,
        content = type.content,
        source = mapToCached(type.source)
    )

    private fun mapToCached(type: SourceHeadlineDataModel) = SourceHeadlineEntity(
        id = type.id,
        name = type.name
    )
}