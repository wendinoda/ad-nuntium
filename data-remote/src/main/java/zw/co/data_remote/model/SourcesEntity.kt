package zw.co.data_remote.model

import kotlinx.serialization.Serializable

@Serializable
data class SourcesSuccessEntity(
    val status: String,
    val sources: List<SourceEntity>
)

@Serializable
data class SourceEntity(
    val id: String,
    val name: String,
    val description: String,
    val url: String,
    val category: String,
    val language: String,
    val country: String,
)

@Serializable
data class SourcesErrorEntity(
    val status: String,
    val sources: ErrorEntity
)

@Serializable
data class ErrorEntity(
    val code: String
)
