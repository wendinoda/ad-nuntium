package zw.co.adnuntium.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import zw.co.data.model.SourceDataModel
import zw.co.data.repository.sources.SourcesCacheRepository
import zw.co.data_cache.Preferences
import zw.co.data_cache.dao.SourceDao
import zw.co.data_cache.db.AdNuntiumDB
import zw.co.data_cache.mapper.Mapper
import zw.co.data_cache.mapper.SourcesEntityMapper
import zw.co.data_cache.model.SourceEntity
import zw.co.data_cache.repository.SourcesCacheRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataCacheModule {

    @Provides
    fun provideChannelDao(appDatabase: AdNuntiumDB): SourceDao {
        return appDatabase.sourcesDao()
    }

    @Singleton
    @Provides
    fun providesPreferences(@ApplicationContext appContext: Context) = Preferences(appContext)

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext appContext: Context): AdNuntiumDB {
        return Room.databaseBuilder(
           appContext ,
            AdNuntiumDB::class.java,
            "AdNuntiumDB"
        ).build()
    }

    @Provides
    fun providesSourcesCacheRepository(
        db: AdNuntiumDB,
        sourcesMapper: SourcesEntityMapper,
        prefs: Preferences
    ): SourcesCacheRepository = SourcesCacheRepositoryImpl(
        db,
        sourcesMapper,
        prefs
    )

    @Provides
    fun providesSourcesEntityMapper(): Mapper<SourceEntity, SourceDataModel> = SourcesEntityMapper()
}