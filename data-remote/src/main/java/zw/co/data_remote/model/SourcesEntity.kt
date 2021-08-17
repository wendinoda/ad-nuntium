package zw.co.data_remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SourcesSuccessEntity(
    @SerialName("status")
    val status: String,
    @SerialName("sources")
    val sources: List<SourceEntity>
)

@Serializable
data class SourceEntity(
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("description")
    val description: String,
    @SerialName("url")
    val url: String,
    @SerialName("category")
    val category: String,
    @SerialName("language")
    val language: String,
    @SerialName("country")
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
