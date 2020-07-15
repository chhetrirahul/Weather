package com.rahul.weather.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.rahul.weather.db.entity.City

@Dao
interface CityDao {

    @Query("SELECT * FROM City")
    fun getAll(): LiveData<List<City>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(city: City)

    @Delete
    fun delete(city: City)
}