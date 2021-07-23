package zw.co.presentation.model


data class SourcesSuccessView(
    val status: String,
    val sources: List<SourceView>,
)

data class SourceView(
    val id: String,
    val name: String,
    val description: String,
    val url: String,
    val category: String,
    val language: String,
    val country: String,
)
