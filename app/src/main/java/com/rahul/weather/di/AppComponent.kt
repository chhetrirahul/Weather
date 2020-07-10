package com.rahul.weather.di

import com.rahul.weather.WeatherApp
import com.rahul.weather.network.di.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityBuildersModule::class,
        ViewModelProviderFactory::class,
        NetworkModule::class
    ]
)
interface AppComponent : AndroidInjector<WeatherApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: WeatherApp): Builder

        fun build(): AppComponent
    }
}