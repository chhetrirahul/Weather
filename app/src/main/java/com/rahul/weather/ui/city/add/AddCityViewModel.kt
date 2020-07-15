package com.rahul.weather.ui.city.add

import android.os.Bundle
import android.text.TextUtils
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rahul.weather.db.entity.City
import com.rahul.weather.db.repository.CityRepository
import com.rahul.weather.ui.base.BaseViewModel
import java.util.concurrent.Executors
import javax.inject.Inject

class AddCityViewModel @Inject constructor(private val cityRepository: CityRepository) :
    BaseViewModel() {

    private var cityName = MutableLiveData("")

    var cityLiveData: LiveData<List<City>> = MutableLiveData()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        cityLiveData = cityRepository.getAll()
    }

    fun getCityName(): MutableLiveData<String> {
        return cityName;
    }

    fun saveCityToDb() {
        if (TextUtils.isEmpty(cityName.value))
            return
        Executors.newSingleThreadExecutor()
            .execute { cityRepository.insert(City(cityName.value!!)) }
    }

    fun deleteCity(city: City) {
        Executors.newSingleThreadExecutor()
            .execute { cityRepository.delete(city) }
    }
}