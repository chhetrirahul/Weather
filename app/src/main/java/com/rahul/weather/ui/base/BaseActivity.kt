package com.rahul.weather.ui.base

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.rahul.weather.R
import com.rahul.weather.ui.main.MainActivity
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.toolbar.*

abstract class BaseActivity<T : ViewDataBinding> : DaggerAppCompatActivity() {

    abstract fun getLayoutId(): Int

    private var mBackPressed: Long = 0

    lateinit var mBinding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, getLayoutId())
        mBinding.lifecycleOwner = this
    }

    fun setToolbar(title: String) {
        setSupportActionBar(toolbar)
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