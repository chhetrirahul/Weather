package com.rahul.weather.ui.city.add

import androidx.recyclerview.widget.RecyclerView
import com.rahul.weather.databinding.ItemCityBinding
import com.rahul.weather.db.entity.City

class CityViewHolder(private val binding: ItemCityBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bindCity(city: City) {
        binding.city = city
    }
}