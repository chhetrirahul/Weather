package com.rahul.weather.ui.city.add

import android.os.Bundle
import com.rahul.weather.R
import com.rahul.weather.ui.base.BaseActivity

class AddCityActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_add_city
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setToolbar(getString(R.string.txt_add_new_city))
    }
}