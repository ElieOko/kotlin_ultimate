package com.example.custom.view.Widget.Country.data

import com.example.custom.R
import java.util.*

data class CountryData(
    private var cCodes: String,
    val countryPhoneCode: String = "+243",
    val cNames:String = "cd",
    val flagResID: Int = R.drawable.cd
) {
    val countryCode = cCodes.lowercase(Locale.getDefault())
}
