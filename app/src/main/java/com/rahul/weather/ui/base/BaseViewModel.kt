package com.rahul.weather.ui.base

import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.rahul.weather.network.helper.ApiResponseHelper
import com.rahul.weather.network.helper.ErrorParser
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

abstract class BaseViewModel : ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    abstract fun onActivityCreated(savedInstanceState: Bundle?)

    fun <T> executeRequest(
        observable: Observable<T>,
        apiHelper: ApiResponseHelper<T>
    ) {
        val disposable = observable.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { t -> apiHelper.onSuccess(t) },
                { t -> apiHelper.onFailure(ErrorParser.getErrorResponse(t as Exception)) })
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}