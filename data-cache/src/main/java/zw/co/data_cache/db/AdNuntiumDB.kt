package zw.co.data_cache.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import zw.co.data_cache.dao.HeadlinesDao
import zw.co.data_cache.dao.SourceDao
import zw.co.data_cache.model.HeadlineArticlesEntity
import zw.co.data_cache.model.SourceEntity

@Database(
    entities = [SourceEntity::class, HeadlineArticlesEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AdNuntiumDB : RoomDatabase() {

    abstract fun sourcesDao(): SourceDao
    abstract fun headlinesDao(): HeadlinesDao

    private var INSTANCE: AdNuntiumDB? = null

    private val sLock = Any()

    fun getInstance(context: Context): AdNuntiumDB {
        if (INSTANCE == null) {
            synchronized(sLock) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AdNuntiumDB::class.java, "AdNuntiumDB.db"
                    )
                        .build()
                }
                return INSTANCE!!
            }
        }
        return INSTANCE!!
    }
}