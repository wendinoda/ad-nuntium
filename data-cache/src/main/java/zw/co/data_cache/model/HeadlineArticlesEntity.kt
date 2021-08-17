package zw.co.data_cache.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HeadlineArticlesEntity(
    @PrimaryKey val sourceId: String,
    @Embedded val source: SourceHeadlineEntity,
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
