package com.rahul.weather.ui.main.di

import androidx.lifecycle.ViewModel
import com.rahul.weather.di.ViewModelKey
import com.rahul.weather.ui.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun providesMainViewModel(mainViewModel: MainViewModel): ViewModel
}