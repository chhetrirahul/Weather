package com.rahul.weather.ui.city.add

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.rahul.weather.R
import com.rahul.weather.databinding.ActivityAddCityBinding
import com.rahul.weather.ui.base.BaseActivity
import javax.inject.Inject

class AddCityActivity : BaseActivity<ActivityAddCityBinding>() {

    @Inject
    lateinit var viewModelProvider: ViewModelProvider.Factory

    lateinit var addCityViewModel: AddCityViewModel

    lateinit var cityListRecyclerAdapter: CityListRecyclerAdapter

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

        setUpRecycler()

        addCityViewModel.cityLiveData.observe(
            this,
            Observer { cityList -> cityListRecyclerAdapter.setData(cityList) })
    }

    private fun setUpRecycler() {
        val linearLayoutManager = LinearLayoutManager(this)
        cityListRecyclerAdapter = CityListRecyclerAdapter()
        mBinding.recycler.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        mBinding.recycler.layoutManager = linearLayoutManager
        mBinding.recycler.adapter = cityListRecyclerAdapter
    }

    fun onAddClicked(view: View) {
        addCityViewModel.saveCityToDb()
    }

    companion object {
        private const val TAG = "AddCityActivity"
    }
}