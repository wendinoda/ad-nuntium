package zw.co.data_cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import zw.co.data_cache.model.SourceEntity

@Dao
interface SourceDao {
    @Query("SELECT * FROM SourceEntity")
    fun getSources(): Flow<List<SourceEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSources(vararg sources: SourceEntity)

    @Query("DELETE FROM SourceEntity")
    fun clearSources()
}