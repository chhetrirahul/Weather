package com.rahul.weather.network.interceptor

import com.rahul.weather.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val newUrl = request.url.newBuilder()
            .addQueryParameter(QUERY_PARAM_APP_ID, BuildConfig.OPEN_WEATHER_API_KEY)
            .build()
        request = request.newBuilder().url(newUrl).build()
        return chain.proceed(request)
    }

    companion object {
        private const val QUERY_PARAM_APP_ID = "appid"
    }
}