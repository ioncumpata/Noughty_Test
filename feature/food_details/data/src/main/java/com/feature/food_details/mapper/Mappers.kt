package com.feature.food_details.mapper

import com.core.network.models.FoodDetailsDTO
import com.core.network.models.MethodDTO
import com.feature.food_details.domain.models.FoodDetails
import com.feature.food_details.domain.models.Method

fun MethodDTO.toMethodDomain(): Method{
    return Method(
        step1 = this.step1,
        step2 = this.step2,
        step3 = this.step3
    )
}

fun FoodDetailsDTO.toFoodDetailsDomain(): FoodDetails{
    return FoodDetails(
        id = this.id,
        title = this.title,
        image = this.image,
        difficulty = this.difficulty,
        description = this.description,
        ingredients = this.ingredients,
        portion = this.portion,
        time = this.time,
        method = this.method.map { it.toMethodDomain() }
    )
}