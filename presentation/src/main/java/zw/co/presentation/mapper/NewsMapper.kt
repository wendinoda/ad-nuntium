package zw.co.presentation.mapper

import zw.co.domain.model.News
import zw.co.presentation.model.NewsView
import javax.inject.Inject

class NewsMapper @Inject constructor(
    private val mapper: HeadlinesMapper
): Mapper<News, NewsView> {
    override fun mapToUi(type: News): NewsView {
        return NewsView(
            status = type.status,
            totalResults = type.totalResults,
            articles = type.articles.map { mapper.mapToUi(it) }
        )
    }

    override fun mapToDomain(type: NewsView): News {
        TODO("Not yet implemented")
    }
}