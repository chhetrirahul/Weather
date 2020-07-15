package com.rahul.weather.db.repository

import androidx.lifecycle.LiveData
import com.rahul.weather.db.dao.CityDao
import com.rahul.weather.db.entity.City
import javax.inject.Inject

class CityRepository @Inject constructor(private val cityDao: CityDao) {

    fun getAll(): LiveData<List<City>> {
        return cityDao.getAll()
    }

    fun insert(city: City) {
        cityDao.insert(city)
    }

    fun delete(city: City) {
        cityDao.delete(city)
    }
}