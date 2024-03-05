package com.feature.food_details.di

import com.core.network.dataproviders.FoodDataProviders
import com.feature.food_details.domain.repository.FoodDetailsRepository
import com.feature.food_details.repositoryimpl.FoodDetailsRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    @Provides
    fun provideFoodDetailsRepository(dataProviders: FoodDataProviders): FoodDetailsRepository{
        return FoodDetailsRepoImpl(dataProviders)
    }
}