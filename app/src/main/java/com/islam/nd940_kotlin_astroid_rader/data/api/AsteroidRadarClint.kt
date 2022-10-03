package com.islam.nd940_kotlin_astroid_rader.data.api

import com.islam.nd940_kotlin_astroid_rader.BuildConfig
import com.islam.nd940_kotlin_astroid_rader.Constants.BASE_URL
import com.islam.nd940_kotlin_astroid_rader.PictureOfDay
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query


object AsteroidRadarClint {

    fun getRetrofitClint(): AstridRadarApi = Retrofit.Builder()
        .baseUrl(BASE_URL).addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory()).build().create()

}


interface AstridRadarApi {

    @GET("planetary/apod")
    fun getPictureOfDay(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY
    ): Call<PictureOfDay>


    @GET("neo/rest/v1/feed")
    fun getAll(
        @Query("start_date") startDate: String,
        @Query("end_date") endDate: String,
        @Query("end_date") apiKey: String = BuildConfig.API_KEY,
    ): Call<String>

}