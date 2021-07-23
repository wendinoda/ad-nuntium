package zw.co.data.model

data class SourcesSuccessDataModel(
    val status: String,
    val sources: List<SourceDataModel>
)

data class SourceErrorDataModel(
    val status: String,
    val sources: ErrorDataModel
)

data class SourceDataModel(
    val id: String,
    val name: String,
    val description: String,
    val url: String,
    val category: String,
    val language: String,
    val country: String,
)

data class ErrorDataModel(
    val id: String,
    val message: String
)