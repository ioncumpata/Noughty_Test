package com.feature.food_details.domain.use_cases

import com.core.common.Resource
import com.feature.food_details.domain.models.FoodDetails
import com.feature.food_details.domain.repository.FoodDetailsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetFoodDetailsUseCase @Inject constructor(
    private val foodDetailsRepository: FoodDetailsRepository
) {

    operator fun invoke(id: String): Flow<Resource<FoodDetails>> = flow {

        emit(Resource.Loading())

        emit(Resource.Success(foodDetailsRepository.getFoodDetails(id = id)))

    }.catch {

        emit(Resource.Error(message = it.message.toString()))

    }.flowOn(Dispatchers.IO)
}