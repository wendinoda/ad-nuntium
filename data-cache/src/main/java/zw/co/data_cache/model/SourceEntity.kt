package zw.co.data_cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class SourceEntity(
    @PrimaryKey val id: String,
    val name: String,
    val description: String,
    val url: String,
    val category: String,
    val language: String,
    val country: String,
)
