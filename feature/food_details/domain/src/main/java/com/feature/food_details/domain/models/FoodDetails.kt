package com.feature.food_details.domain.models

data class FoodDetails(
    val description: String,
    val difficulty: String,
    val id: String,
    val image: String,
    val ingredients: List<String>,
    val method: List<Method>,
    val portion: String,
    val time: String,
    val title: String
)
