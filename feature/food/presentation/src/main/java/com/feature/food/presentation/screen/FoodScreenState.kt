package com.feature.food.presentation.screen

import com.feature.food.domain.models.Food

data class FoodScreenState(
    val isLoading: Boolean = false,
    val data: List<Food>? = null,
    val error: String = ""
)
