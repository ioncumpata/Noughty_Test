package com.feature.food.presentation.di

import com.feature.food.presentation.navigation.FoodApi
import com.feature.food.presentation.navigation.FoodApiImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object PresentationLayerModule {

    @Provides
    fun provideFoodApi(): FoodApi{
        return FoodApiImpl()
    }
}