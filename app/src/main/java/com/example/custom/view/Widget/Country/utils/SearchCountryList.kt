package com.example.custom.view.Widget.Country.utils

import android.content.Context
import com.example.custom.view.Widget.Country.data.CountryData
import com.example.custom.view.Widget.Country.data.utils.getCountryName

fun List<CountryData>.searchCountry(key: String, context: Context): MutableList<CountryData> {
    val tempList = mutableListOf<CountryData>()
    this.forEach {
        if (context.resources.getString(getCountryName(it.countryCode)).lowercase().contains(key.lowercase())) {
            tempList.add(it)
        }
    }
    return tempList
}