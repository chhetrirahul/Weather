package com.rahul.weather

import com.rahul.weather.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class WeatherApp : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}