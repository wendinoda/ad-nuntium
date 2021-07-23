package zw.co.data_cache

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class Preferences @Inject constructor(context: Context) {

    companion object {
        private const val PREF_PACKAGE_NAME = "zw.co.data_cache.preferences"
        private const val PREF_KEY_LAST_CACHE_HEADLINES = "last_cache_headlines"
        private const val PREF_KEY_LAST_CACHE_SOURCES = "last_cache_sources"
    }

    private val pref: SharedPreferences =
        context.getSharedPreferences(PREF_PACKAGE_NAME, Context.MODE_PRIVATE)

    var lastCacheTimeHeadlines: Long
        get() = pref.getLong(PREF_KEY_LAST_CACHE_HEADLINES, 0)
        set(lastCache) = pref.edit().putLong(PREF_KEY_LAST_CACHE_HEADLINES, lastCache).apply()

    var lastCacheTimeSources: Long
        get() = pref.getLong(PREF_KEY_LAST_CACHE_SOURCES, 0)
        set(lastCache) = pref.edit().putLong(PREF_KEY_LAST_CACHE_SOURCES, lastCache).apply()
}