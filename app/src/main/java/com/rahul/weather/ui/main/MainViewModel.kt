package com.rahul.weather.ui.main

import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.rahul.weather.network.api.OpenWeatherApiService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(private val openWeatherApiService: OpenWeatherApiService) :
    ViewModel() {

    var compositeDisposable: CompositeDisposable? = null

    fun onActivityCreated(savedInstanceState: Bundle?) {

        compositeDisposable = CompositeDisposable()

        compositeDisposable!!.add(
            openWeatherApiService.getWeatherForCity("Sydney")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response -> }, { t -> })
        )
    }


    override fun onCleared() {
        super.onCleared()
        compositeDisposable?.dispose()
    }

    companion object {
        private const val TAG = "MainViewModel"
    }
}