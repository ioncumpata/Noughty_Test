package com.feature.food_details.presentation.di

import com.feature.food_details.presentation.navigation.FoodDetailsApi
import com.feature.food_details.presentation.navigation.FoodDetailsApiImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object PresentationModule {

    @Provides
    fun provideFoodDetailsApiImpl(): FoodDetailsApi{
        return FoodDetailsApiImpl()
    }



}