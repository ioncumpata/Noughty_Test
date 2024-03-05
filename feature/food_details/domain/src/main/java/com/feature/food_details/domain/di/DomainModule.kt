package com.feature.food_details.domain.di

import com.feature.food_details.domain.repository.FoodDetailsRepository
import com.feature.food_details.domain.use_cases.GetFoodDetailsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainModule {

    @Provides
    fun provideFoodDetailsUseCase(foodDetailsRepository: FoodDetailsRepository): GetFoodDetailsUseCase{
        return GetFoodDetailsUseCase(foodDetailsRepository)
    }
}