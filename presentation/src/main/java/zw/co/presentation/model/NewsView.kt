package zw.co.presentation.model

data class NewsView(
    val status: String,
    val totalResults: Int,
    val articles: List<ArticlesView>
)
