package com.feature.food_details.repositoryimpl

import com.core.network.dataproviders.FoodDataProviders
import com.feature.food_details.domain.models.FoodDetails
import com.feature.food_details.domain.repository.FoodDetailsRepository
import com.feature.food_details.mapper.toFoodDetailsDomain
import javax.inject.Inject

class FoodDetailsRepoImpl @Inject constructor(private val dataProviders: FoodDataProviders): FoodDetailsRepository {
    override suspend fun getFoodDetails(id: String): FoodDetails {
        return dataProviders.getFoodDetails(id = id).toFoodDetailsDomain()
    }
}