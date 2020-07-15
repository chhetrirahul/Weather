package com.rahul.weather.db.di

import androidx.room.Room
import com.rahul.weather.WeatherApp
import com.rahul.weather.db.AppDatabase
import com.rahul.weather.db.dao.CityDao
import com.rahul.weather.db.repository.CityRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {

    @Singleton
    @Provides
    fun providesAppDatabase(application: WeatherApp): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "weather-db").build()
    }

    @Singleton
    @Provides
    fun providesCityDao(appDatabase: AppDatabase): CityDao {
        return appDatabase.cityDao()
    }

    @Singleton
    @Provides
    fun providesCityRepository(cityDao: CityDao): CityRepository {
        return CityRepository(cityDao)
    }
}