package com.rahul.weather.ui.city.add

import com.rahul.weather.db.entity.City

interface CityDeleteListener {
    fun delete(city: City)
}