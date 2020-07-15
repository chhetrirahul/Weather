package com.rahul.weather.ui.city.add

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rahul.weather.databinding.ItemCityBinding
import com.rahul.weather.db.entity.City
import java.util.*

class CityListRecyclerAdapter :
    RecyclerView.Adapter<CityViewHolder>() {

    var cityList = ArrayList<City>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemCityBinding =
            ItemCityBinding.inflate(layoutInflater, parent, false)
        return CityViewHolder(itemCityBinding)
    }

    override fun getItemCount(): Int {
        return cityList.size
    }

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val city = cityList[position]
        holder.bindCity(city)
    }

    fun setData(cityList: List<City>) {
        this.cityList.addAll(cityList)
        notifyDataSetChanged()
    }
}