package com.example.custom.view.Widget.Onboarding

object Global {
    val title = mapOf("title1" to "Pesa sango l'information dans votre poche", "title2" to "", "title3" to "")
    val description = mapOf("desc1" to "Soyez informer au quotidient sur les actualités", "desc2" to "", "desc3" to "")
}

fun main() {
  println(Global.title["title1"].toString())
}