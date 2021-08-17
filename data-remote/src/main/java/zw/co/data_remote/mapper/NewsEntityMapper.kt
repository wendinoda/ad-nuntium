package zw.co.data_remote.mapper

import zw.co.data.model.NewsDataModel
import zw.co.data_remote.model.NewsEntity
import javax.inject.Inject

class NewsEntityMapper @Inject constructor(
    private val mapper: HeadlinesEntityMapper
) :
    Mapper<NewsEntity, NewsDataModel> {
    override fun mapFromEntity(type: NewsEntity): NewsDataModel {
        return NewsDataModel(
            status = type.status,
            totalResults = type.totalResults,
            articles = type.articles.map { mapper.mapFromEntity(it) }
        )
    }
}