package zw.co.adnuntium.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import zw.co.data.model.ArticlesDataModel
import zw.co.data.model.SourceDataModel
import zw.co.data.repository.headlines.HeadlinesCacheRepository
import zw.co.data.repository.sources.SourcesCacheRepository
import zw.co.data_cache.Preferences
import zw.co.data_cache.dao.SourceDao
import zw.co.data_cache.db.AdNuntiumDB
import zw.co.data_cache.mapper.DateFormatter
import zw.co.data_cache.mapper.HeadlinesEntityMapper
import zw.co.data_cache.mapper.Mapper
import zw.co.data_cache.mapper.SourcesEntityMapper
import zw.co.data_cache.model.HeadlineArticlesEntity
import zw.co.data_cache.model.SourceEntity
import zw.co.data_cache.repository.HeadlinesCacheRepositoryImpl
import zw.co.data_cache.repository.SourcesCacheRepositoryImpl
import zw.co.data_remote.model.ArticlesEntity
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataCacheModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext appContext: Context): AdNuntiumDB {
        return Room.databaseBuilder(
            appContext,
            AdNuntiumDB::class.java,
            "AdNuntiumDB"
        ).build()
    }

    @Singleton
    @Provides
    fun providesPreferences(@ApplicationContext appContext: Context) = Preferences(appContext)

    @Provides
    fun provideSourceDao(appDatabase: AdNuntiumDB): SourceDao {
        return appDatabase.sourcesDao()
    }


    @Provides
    fun providesSourcesEntityMapper(): Mapper<SourceEntity, SourceDataModel> = SourcesEntityMapper()

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
    fun providesHeadlinesHEntityMapper(
        dateFormatter: DateFormatter
    ): Mapper<HeadlineArticlesEntity, ArticlesDataModel> =
        HeadlinesEntityMapper(dateFormatter)

    @Provides
    fun providesHeadlinesCacheRepository(
        db: AdNuntiumDB,
        headlinesMapper: HeadlinesEntityMapper,
        prefs: Preferences
    ): HeadlinesCacheRepository = HeadlinesCacheRepositoryImpl(
        db,
        headlinesMapper,
        prefs
    )
}