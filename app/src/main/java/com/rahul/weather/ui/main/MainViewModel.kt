package com.rahul.weather.ui.main

import android.os.Bundle
import com.google.gson.Gson
import com.rahul.weather.network.api.OpenWeatherApiService
import com.rahul.weather.network.data.ErrorResponse
import com.rahul.weather.network.data.WeatherResponse
import com.rahul.weather.network.helper.ApiResponseHelper
import com.rahul.weather.ui.base.BaseViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(private val openWeatherApiService: OpenWeatherApiService) :
    BaseViewModel() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {

        executeRequest(
            openWeatherApiService.getWeatherForCity("sydney"),
            object : ApiResponseHelper<WeatherResponse> {
                override fun onSuccess(data: WeatherResponse) {
                    println(Gson().toJson(data))
                }

                override fun onFailure(errorResponse: ErrorResponse) {
                    println(Gson().toJson(errorResponse))
                }
            }
        )
    }
}