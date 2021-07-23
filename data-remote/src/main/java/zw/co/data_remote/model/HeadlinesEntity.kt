package zw.co.data_remote.model

data class HeadlinesEntity (
    val status: String,
    val totalResults: Int,
    val articles: List<ArticlesEntity>
        )

data class ArticlesEntity(
    val source: SourceHeadlineEntity,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
)

data class SourceHeadlineEntity(
    val id: String?,
    val name: String,
)
