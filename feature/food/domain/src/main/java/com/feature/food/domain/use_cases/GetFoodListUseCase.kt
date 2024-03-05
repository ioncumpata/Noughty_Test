package com.feature.food.domain.use_cases

import android.util.Log
import com.core.common.Resource
import com.feature.food.domain.models.Food
import com.feature.food.domain.repository.FoodRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetFoodListUseCase @Inject constructor(
    private val foodRepository: FoodRepository
) {

    operator fun invoke() = flow<Resource<List<Food>>> {

        emit(Resource.Loading())
        emit(Resource.Success(foodRepository.getFoodList()))
    }.catch {
        emit(Resource.Error(it.message.toString()))
    }.flowOn(Dispatchers.IO)
}