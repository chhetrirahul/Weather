package com.rahul.weather.network.helper

import com.google.gson.Gson
import com.rahul.weather.R
import com.rahul.weather.WeatherApp
import com.rahul.weather.network.data.ErrorResponse
import retrofit2.HttpException
import java.net.UnknownHostException

class ErrorParser {
    companion object {
        fun getErrorResponse(exception: Exception): ErrorResponse {
            return when (exception) {
                is HttpException -> {
                    Gson().fromJson<ErrorResponse>(
                        exception.response()?.errorBody()?.string(), ErrorResponse::class.java
                    )
                }
                is UnknownHostException -> {
                    ErrorResponse(
                        0,
                        WeatherApp.appContext.getString(R.string.error_unknown_host_exception)
                    )
                }
                else -> {
                    ErrorResponse(0, WeatherApp.appContext.getString(R.string.error_unknown))
                }
            }
        }
    }
}