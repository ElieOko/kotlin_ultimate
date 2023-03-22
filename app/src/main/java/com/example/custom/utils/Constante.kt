package com.example.custom.utils

class Article(
    val article: String,
    val desc: String
) {
    companion object{
        fun getData(): List<Article>{
            return listOf(
                Article(article ="Article 1: Introduction",desc ="Il est formé entre les soussignés une socièté..."),
                Article(article ="Article 2: Introduction",desc ="Il est formé entre les soussignés une socièté..."),
                Article(article ="Article 3: Introduction",desc ="Il est formé entre les soussignés une socièté...")
            )
        }
    }
}
