package com.feature.food.data.repositoryimpl

import com.core.network.dataproviders.FoodDataProviders
import com.feature.food.data.mapper.toDomainFoodList
import com.feature.food.domain.models.Food
import com.feature.food.domain.repository.FoodRepository
import javax.inject.Inject

class FoodRepositoryImpl @Inject constructor(private val foodDataProviders: FoodDataProviders) :
    FoodRepository {
    override suspend fun getFoodList(): List<Food> {

        return foodDataProviders.getFoodList().toDomainFoodList()
    }

}