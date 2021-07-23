package zw.co.domain.model

import org.joda.time.DateTime

data class Headlines(
    val status: String,
    val totalResults: Int,
    val articles: List<Articles>
)

data class Articles(
    val source: SourceHeadline,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: DateTime,
    val content: String
)

data class SourceHeadline(
    val id: String?,
    val name: String,
)