package zw.co.data.model

import org.joda.time.DateTime

data class HeadlinesDataModel(
    val status: String,
    val totalResults: Int,
    val articles: List<ArticlesDataModel>
)

data class ArticlesDataModel(
    val source: SourceHeadlineDataModel,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: DateTime?,
    val content: String?
)

data class SourceHeadlineDataModel(
    val id: String?,
    val name: String?,
)