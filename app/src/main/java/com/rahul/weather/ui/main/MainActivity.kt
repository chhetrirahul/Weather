package com.rahul.weather.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import com.rahul.weather.R
import com.rahul.weather.ui.base.BaseActivity
import com.rahul.weather.ui.city.add.AddCityActivity
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var viewModelProvider: ViewModelProvider.Factory

    lateinit var mainViewModel: MainViewModel

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel = ViewModelProvider(this, viewModelProvider).get(MainViewModel::class.java)
        mainViewModel.onActivityCreated(savedInstanceState)
        setToolbar(getString(R.string.app_name))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_add -> {
                openAddCityActivity()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun openAddCityActivity() {
        val intent = Intent(this, AddCityActivity::class.java)
        startActivity(intent)
    }
}