package com.feature.food.domain.repository

import com.feature.food.domain.models.Food

interface FoodRepository {

    suspend fun getFoodList(): List<Food>
}