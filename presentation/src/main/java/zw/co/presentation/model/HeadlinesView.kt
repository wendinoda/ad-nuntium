package zw.co.presentation.model

import org.joda.time.DateTime

data class HeadlinesView(
    val status: String,
    val totalResults: Int,
    val articles: List<ArticlesView>
)

data class ArticlesView(
    val source: SourceHeadlineView,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: DateTime?,
    val content: String?
)

data class SourceHeadlineView(
    val id: String?,
    val name: String?,
)
