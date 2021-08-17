package zw.co.data.model

data class NewsDataModel(
    val status: String,
    val totalResults: Int,
    val articles: List<ArticlesDataModel>
)
