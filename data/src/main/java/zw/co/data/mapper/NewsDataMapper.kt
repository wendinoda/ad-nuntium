package zw.co.data.mapper

import zw.co.data.model.NewsDataModel
import zw.co.domain.model.News
import javax.inject.Inject

class NewsDataMapper @Inject constructor(
    private val mapper: HeadlinesDataMapper
) : Mapper<NewsDataModel, News> {
    override fun mapFromEntity(type: NewsDataModel) = News(
        status = type.status,
        totalResults = type.totalResults,
        articles = type.articles.map {
            mapper.mapFromEntity(it)
        }
    )

    override fun mapToEntity(type: News): NewsDataModel {
        TODO("Not yet implemented")
    }
}