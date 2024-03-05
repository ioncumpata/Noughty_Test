package com.core.network.dataproviders

import com.core.network.ApiService
import javax.inject.Inject

class FoodDataProviders @Inject constructor(private val apiService: ApiService) {

    suspend fun getFoodList() = apiService.getFoodList()

    suspend fun getFoodDetails(id: String) = apiService.getFoodDetails(foodId = id)
}