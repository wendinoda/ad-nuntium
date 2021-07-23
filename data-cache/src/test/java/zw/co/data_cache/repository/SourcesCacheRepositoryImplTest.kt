package zw.co.data_cache.repository

import android.os.Build
import androidx.room.Room
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import zw.co.data_cache.Preferences
import zw.co.data_cache.db.AdNuntiumDB
import zw.co.data_cache.mapper.SourcesEntityMapper
import zw.co.data_cache.model.SourceEntity
import zw.co.test_module.TestCoroutineRule

@ExperimentalCoroutinesApi
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O])
class SourcesCacheRepositoryImplTest {
    private lateinit var sourcesRepository: SourcesCacheRepositoryImpl
    private lateinit var adNuntiumDB: AdNuntiumDB
    private lateinit var prefs: Preferences

    @Mock
    lateinit var mapper: SourcesEntityMapper

    @Before
    fun init() {
        adNuntiumDB =
            Room.inMemoryDatabaseBuilder(RuntimeEnvironment.systemContext, AdNuntiumDB::class.java)
                .allowMainThreadQueries().build()
        prefs = Preferences(RuntimeEnvironment.systemContext)
        sourcesRepository = SourcesCacheRepositoryImpl(
            adNuntiumDB,
            mapper,
            prefs
        )
    }

    @JvmField
    @Rule
    val coroutineRule = TestCoroutineRule()

    @After
    fun closeDb(){
        adNuntiumDB.close()
    }
}