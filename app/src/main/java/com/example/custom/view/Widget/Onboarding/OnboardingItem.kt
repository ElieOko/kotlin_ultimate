package com.example.custom.view.Widget.Onboarding

import com.example.custom.R

class OnBoardingItems(
    val image: Int,
    val title: String,
    val desc: String
) {
    companion object{
        fun getData(): List<OnBoardingItems>{
            return listOf(
                OnBoardingItems(image = R.drawable.head, title = Global.title["title1"].toString(), desc = Global.description["desc1"].toString()),
                OnBoardingItems(image = R.drawable.head, Global.title["title2"].toString(),desc = Global.description["desc2"].toString()),
                OnBoardingItems(image = R.drawable.head,Global.title["title3"].toString(), desc = Global.description["desc3"].toString())
            )
        }
    }
}