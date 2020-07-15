package com.rahul.weather.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class City(
    @ColumnInfo val name: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}