package com.rahul.weather.network.api

import com.rahul.weather.network.data.WeatherResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface OpenWeatherApiService {
    @GET("weather")
    fun getWeatherForCity(@Query("q") city: String): Observable<WeatherResponse>
}