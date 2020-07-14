package com.rahul.weather.di

import com.rahul.weather.ui.city.add.AddCityActivity
import com.rahul.weather.ui.main.MainActivity
import com.rahul.weather.ui.main.di.MainViewModelModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
        modules = [MainViewModelModule::class]
    )
    abstract fun providesMainActivity(): MainActivity

    @ContributesAndroidInjector()
    abstract fun providesAddCityActivity(): AddCityActivity
}