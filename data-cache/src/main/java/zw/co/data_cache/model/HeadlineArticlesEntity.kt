package zw.co.data_cache.model

import androidx.room.Embedded
import androidx.room.Entity
import org.joda.time.DateTime

@Entity
data class HeadlineArticlesEntity(
    @Embedded val source: SourceHeadlineEntity,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: DateTime,
    val content: String
)

data class SourceHeadlineEntity(
    val id: String?,
    val name: String,
)
