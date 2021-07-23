package zw.co.data_remote.network

import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import zw.co.data_remote.BuildConfig
import zw.co.data_remote.model.HeadlinesEntity
import zw.co.data_remote.model.SourcesSuccessEntity

interface RestService {
    @GET("/v2/sources")
    suspend fun getSources(@Header("X-Api-Key") apiKey: String = BuildConfig.API_KEY): Flow<SourcesSuccessEntity>

    @GET("v2/top-headlines")
    suspend fun getHeadlines(@Header("X-Api-Key") apiKey: String = BuildConfig.API_KEY): Flow<HeadlinesEntity>

    @GET("v2/top-headlines")
    suspend fun getHeadlinesByCategory(
        @Query("category") category: String,
        @Header("X-Api-Key") apiKey: String = BuildConfig.API_KEY
    ): Flow<HeadlinesEntity>
}