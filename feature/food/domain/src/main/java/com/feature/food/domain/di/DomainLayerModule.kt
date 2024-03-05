package com.feature.food.domain.di

import com.feature.food.domain.repository.FoodRepository
import com.feature.food.domain.use_cases.GetFoodListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainLayerModule {

    @Provides
    fun provideGetFoodListUseCase(foodRepository: FoodRepository): GetFoodListUseCase {
        return GetFoodListUseCase(foodRepository)
    }
}