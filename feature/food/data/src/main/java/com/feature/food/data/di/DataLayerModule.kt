package com.feature.food.data.di

import com.core.network.dataproviders.FoodDataProviders
import com.feature.food.data.repositoryimpl.FoodRepositoryImpl
import com.feature.food.domain.repository.FoodRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DataLayerModule {

    @Provides
    fun provideFoodRepositoryImpl(foodDataProviders: FoodDataProviders): FoodRepository {
        return FoodRepositoryImpl(foodDataProviders)
    }
}