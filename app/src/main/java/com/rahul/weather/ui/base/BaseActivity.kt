package com.rahul.weather.ui.base

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.rahul.weather.R
import com.rahul.weather.ui.main.MainActivity
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity : DaggerAppCompatActivity() {

    abstract fun getLayoutId(): Int

    private var mBackPressed: Long = 0

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

    override fun onBackPressed() {
        if (this is MainActivity) {
            if (mBackPressed + DELAY > System.currentTimeMillis()) {
                super.onBackPressed()
                return
            } else {
                Toast.makeText(this, getString(R.string.msg_press_back_to_exit), Toast.LENGTH_SHORT)
                    .show()
            }
            mBackPressed = System.currentTimeMillis()
        } else {
            super.onBackPressed()
        }
    }

    companion object {
        private const val DELAY = 2000L
    }
}