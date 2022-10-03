package com.islam.nd940_kotlin_astroid_rader.data

import androidx.lifecycle.LiveData
import com.islam.nd940_kotlin_astroid_rader.PictureOfDay
import com.islam.nd940_kotlin_astroid_rader.data.api.getSevenDaysDateFormatted
import com.islam.nd940_kotlin_astroid_rader.data.api.getTodayFormats
import com.islam.nd940_kotlin_astroid_rader.models.Asteroid


interface MainRepository {

    suspend fun getAllAsync(
        startDate: String = getTodayFormats(),
        endDate: String = getSevenDaysDateFormatted()
    )


    suspend fun getAsteroidRadarPictureOfDayAsync(): PictureOfDay?

    fun getAllASteroidRadar(): LiveData<List<Asteroid>>

    fun getTodayASteroidRadar(startDate: String, closeDate: String): LiveData<List<Asteroid>>

    fun deleteAll()

    fun insetAll(asteroidRadar: List<Asteroid>)

    fun getCount(): Int
}