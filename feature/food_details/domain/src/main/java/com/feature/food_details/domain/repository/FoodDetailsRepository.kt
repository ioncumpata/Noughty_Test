package com.feature.food_details.domain.repository

import com.feature.food_details.domain.models.FoodDetails

interface FoodDetailsRepository {

    suspend fun getFoodDetails(id: String): FoodDetails
}