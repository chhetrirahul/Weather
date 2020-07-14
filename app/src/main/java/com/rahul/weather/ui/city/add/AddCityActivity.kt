package com.rahul.weather.ui.city.add

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.rahul.weather.R
import com.rahul.weather.databinding.ActivityAddCityBinding
import com.rahul.weather.ui.base.BaseActivity
import javax.inject.Inject

class AddCityActivity : BaseActivity<ActivityAddCityBinding>() {

    @Inject
    lateinit var viewModelProvider: ViewModelProvider.Factory

    lateinit var addCityViewModel: AddCityViewModel

    override fun getLayoutId(): Int {
        return R.layout.activity_add_city
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addCityViewModel =
            ViewModelProvider(this, viewModelProvider).get(AddCityViewModel::class.java)
        addCityViewModel.onActivityCreated(savedInstanceState)
        setToolbar(getString(R.string.txt_add_new_city))
        mBinding.viewModel = addCityViewModel
    }

    fun onAddClicked(view: View) {
        addCityViewModel.saveCityToDb()
    }

    companion object {
        private const val TAG = "AddCityActivity"
    }
}