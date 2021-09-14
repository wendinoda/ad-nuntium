package zw.co.data_remote.model

import com.squareup.moshi.Json
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class SourcesSuccessEntity(
    @Json(name = "status")
    val status: String,
    @Json(name = "sources")
    val sources: List<SourceEntity>
)

data class SourceEntity(
    @Json(name = "id")
    val id: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "description")
    val description: String,
    @Json(name = "url")
    val url: String,
    @Json(name = "category")
    val category: String,
    @Json(name = "language")
    val language: String,
    @Json(name = "country")
    val country: String,
)
