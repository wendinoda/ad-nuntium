package zw.co.data_remote.model

import com.squareup.moshi.Json
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


data class HeadlinesEntity(
    @Json(name = "status")
    val status: String,
    @Json(name = "totalResults")
    val totalResults: Int,
    @Json(name = "articles")
    val articles: List<ArticlesEntity>
)

data class ArticlesEntity(
    @Json(name = "source")
    val source: SourceHeadlineEntity,
    @Json(name = "author")
    val author: String?,
    @Json(name = "title")
    val title: String?,
    @Json(name = "description")
    val description: String?,
    @Json(name = "url")
    val url: String?,
    @Json(name = "urlToImage")
    val urlToImage: String?,
    @Json(name = "publishedAt")
    val publishedAt: String?,
    @Json(name = "content")
    val content: String?
)

data class SourceHeadlineEntity(
    @Json(name = "id")
    val id: String?,
    @Json(name = "name")
    val name: String?,
)
