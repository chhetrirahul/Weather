package com.rahul.weather.network.di

import com.rahul.weather.network.api.OpenWeatherApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class OpenWeatherApiModule {
    @Provides
    @Singleton
    fun providesOpenWeatherApiService(retrofit: Retrofit): OpenWeatherApiService {
        return retrofit.create(OpenWeatherApiService::class.java)
    }
}