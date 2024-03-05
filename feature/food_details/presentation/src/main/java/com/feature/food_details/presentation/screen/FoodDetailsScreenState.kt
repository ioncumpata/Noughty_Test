package com.feature.food_details.presentation.screen

import com.feature.food_details.domain.models.FoodDetails

data class FoodDetailsScreenState(
    val isLoading: Boolean = false,
    val data: FoodDetails? = null,
    val error: String = ""
)