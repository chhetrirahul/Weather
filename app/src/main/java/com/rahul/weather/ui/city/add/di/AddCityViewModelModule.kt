package com.rahul.weather.ui.city.add.di

import androidx.lifecycle.ViewModel
import com.rahul.weather.di.ViewModelKey
import com.rahul.weather.ui.city.add.AddCityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AddCityViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(AddCityViewModel::class)
    abstract fun providesAddCityViewModel(addCityViewModel: AddCityViewModel): ViewModel
}