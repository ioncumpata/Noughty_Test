package dev.cumpataion.noughtytest.navigation

import com.feature.food.presentation.navigation.FoodApi
import com.feature.food_details.presentation.navigation.FoodDetailsApi

data class NavigationProvider(
    val foodApi: FoodApi,
    val foodDetailsApi: FoodDetailsApi,

)
