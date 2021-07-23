package zw.co.data_cache.dao

import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import zw.co.data_cache.db.AdNuntiumDB
import zw.co.data_cache.model.SourceEntity
import zw.co.test_module.TestCoroutineRule


@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.P])
open class SourcesDaoTest {

    private lateinit var adNuntiumDB: AdNuntiumDB

    @JvmField
    @Rule
    val coroutineRule = TestCoroutineRule()

    @Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun openDb() {
        adNuntiumDB = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AdNuntiumDB::class.java
        ).allowMainThreadQueries().build()
    }

    @After
    fun closeDb() {
        adNuntiumDB.close()
    }

    @Test
    fun saveSources()  {
        runBlocking {
            adNuntiumDB.sourcesDao().insertSources(*getSourcesEntity().toTypedArray())
            val sources = adNuntiumDB.sourcesDao().getSources()
            assert(sources.single().isNotEmpty())
        }
    }

    private fun getSourcesEntity(): List<SourceEntity> = listOf(
        SourceEntity(
            id = "2",
            name = "BBC",
            description = "News",
            url = "bbc.com",
            category = "news",
            language = "eng",
            country = "uk"
        ),
        SourceEntity(
            id = "2",
            name = "BBC",
            description = "News",
            url = "bbc.com",
            category = "news",
            language = "eng",
            country = "uk"
        )
    )
}