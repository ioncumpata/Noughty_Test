package dev.cumpataion.noughtytest.di

import com.feature.food.presentation.navigation.FoodApi
import com.feature.food_details.presentation.navigation.FoodDetailsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.cumpataion.noughtytest.navigation.NavigationProvider

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideNavigationProvider(foodApi: FoodApi, foodDetailsApi: FoodDetailsApi): NavigationProvider{
        return NavigationProvider(foodApi, foodDetailsApi)
    }
}