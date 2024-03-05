package com.core.network.models

data class FoodDetailsDTO(
    val description: String,
    val difficulty: String,
    val id: String,
    val image: String,
    val ingredients: List<String>,
    val method: List<MethodDTO>,
    val portion: String,
    val time: String,
    val title: String
)