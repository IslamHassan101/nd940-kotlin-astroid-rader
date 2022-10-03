package com.islam.nd940_kotlin_astroid_rader.data.localdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.islam.nd940_kotlin_astroid_rader.models.Asteroid


@Database(entities = [Asteroid::class], version = 1, exportSchema = false)
abstract class AsteroidRadarDataBase : RoomDatabase() {

    abstract val asteroidRadarDao: AsteroidRadarDao

    companion object {

        private var INSTANCE: AsteroidRadarDataBase? = null

        fun getInstance(context: Context): AsteroidRadarDataBase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AsteroidRadarDataBase::class.java,
                        "asteroid_radar_database"
                    ).fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}
