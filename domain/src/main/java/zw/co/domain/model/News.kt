package zw.co.domain.model

data class News(
    val status: String,
    val totalResults: Int,
    val articles: List<Articles>
)