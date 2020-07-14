package com.rahul.weather.ui.city.add

import android.os.Bundle
import android.text.TextUtils
import androidx.lifecycle.MutableLiveData
import com.rahul.weather.ui.base.BaseViewModel
import javax.inject.Inject

class AddCityViewModel @Inject constructor() : BaseViewModel() {

    private var cityName = MutableLiveData("")

    override fun onActivityCreated(savedInstanceState: Bundle?) {

    }

    fun getCityName(): MutableLiveData<String> {
        return cityName;
    }

    fun saveCityToDb() {
        if (TextUtils.isEmpty(cityName.value))
            return
        
    }
}