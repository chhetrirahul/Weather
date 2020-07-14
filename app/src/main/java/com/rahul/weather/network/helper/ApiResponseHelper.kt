package com.rahul.weather.network.helper

import com.rahul.weather.network.data.ErrorResponse

interface ApiResponseHelper<T> {

    fun onSuccess(data: T)

    fun onFailure(errorResponse: ErrorResponse)
}