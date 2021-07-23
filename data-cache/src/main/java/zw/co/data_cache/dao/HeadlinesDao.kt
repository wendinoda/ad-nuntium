package zw.co.data_cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import zw.co.data_cache.model.HeadlineArticlesEntity

@Dao
interface HeadlinesDao {
    @Query("SELECT * FROM HeadlineArticlesEntity")
    fun getHeadlines(): Flow<List<HeadlineArticlesEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertHeadlines(vararg headlines: HeadlineArticlesEntity)

    @Query("DELETE FROM HeadlineArticlesEntity")
    fun clearHeadlines()
}
