package com.rahul.weather.ui.base

import android.os.Bundle
import android.view.MenuItem
import com.rahul.weather.R
import com.rahul.weather.ui.main.MainActivity
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity : DaggerAppCompatActivity() {

    abstract fun getLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
    }

    fun setToolbar(title: String) {
        setSupportActionBar(findViewById(R.id.toolbar))
        if (this !is MainActivity)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = title
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else ->
                super.onOptionsItemSelected(item)
        }
    }
}