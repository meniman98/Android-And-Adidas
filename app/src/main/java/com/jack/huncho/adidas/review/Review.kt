package com.jack.huncho.adidas.review

import java.time.LocalDate

data class Review(
    val title: String,
    val name: String,
    val desc: String,
    val rating: Int,
    val date: LocalDate,
    val id: Long
)