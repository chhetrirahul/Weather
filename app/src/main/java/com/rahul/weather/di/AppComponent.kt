package com.rahul.weather.di

import com.rahul.weather.WeatherApp
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
        ViewModelProviderFactory::class
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