package com.rahul.weather.ui.city.add

import androidx.recyclerview.widget.DiffUtil
import com.rahul.weather.db.entity.City

class CityDiffCallback(private val oldList: List<City>, private val newList: List<City>) :
    DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size


    override fun getNewListSize(): Int = newList.size


    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}