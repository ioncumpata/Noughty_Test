package com.feature.food.data.mapper

import com.core.network.models.FoodListResponse
import com.feature.food.domain.models.Food

fun FoodListResponse.toDomainFoodList(): List<Food> {
    return this.map {
        Food(
            difficulty = it.difficulty,
            id = it.id,
            image = it.image,
            title = it.title
        )
    }
}