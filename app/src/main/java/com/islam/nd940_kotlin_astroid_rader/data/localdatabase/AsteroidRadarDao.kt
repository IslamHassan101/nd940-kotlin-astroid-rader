package com.islam.nd940_kotlin_astroid_rader.data.localdatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.islam.nd940_kotlin_astroid_rader.models.Asteroid


@Dao
interface AsteroidRadarDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAsteroid(asteroidRadar: List<Asteroid>)


    @Query("SELECT * FROM asteroid_table ORDER BY closeApproachDate")
    fun getAsteroid(): LiveData<List<Asteroid>>

    @Query("SELECT COUNT(*) FROM asteroid_table")
    fun getCount(): Int

    @Query("DELETE FROM asteroid_table")
    fun delete()

    @Query("SELECT * FROM asteroid_table WHERE closeApproachDate >= :startData AND closeApproachDate <= :closeDate ORDER BY closeApproachDate ASC")
    fun getToday(startData: String, closeDate: String): LiveData<List<Asteroid>>

}
