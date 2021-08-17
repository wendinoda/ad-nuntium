package zw.co.data_remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HeadlinesEntity(
    @SerialName("status")
    val status: String,
    @SerialName("totalResults")
    val totalResults: Int,
    @SerialName("articles")
    val articles: List<ArticlesEntity>
)

@Serializable
data class ArticlesEntity(
    @SerialName("source")
    val source: SourceHeadlineEntity,
    @SerialName("author")
    val author: String,
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val description: String,
    @SerialName("url")
    val url: String,
    @SerialName("urlToImage")
    val urlToImage: String,
    @SerialName("publishedAt")
    val publishedAt: String,
    @SerialName("content")
    val content: String
)

@Serializable
data class SourceHeadlineEntity(
    @SerialName("id")
    val id: String?,
    @SerialName("name")
    val name: String,
)
