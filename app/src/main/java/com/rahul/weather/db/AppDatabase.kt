package com.rahul.weather.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rahul.weather.db.dao.CityDao
import com.rahul.weather.db.entity.City

@Database(
    entities = [
        City::class
    ], version = AppDatabase.DB_VERSION, exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun cityDao(): CityDao

    companion object {
        const val DB_VERSION = 1
    }
}