package com.core.network.di

import com.core.network.ApiService
import com.core.network.dataproviders.FoodDataProviders
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {


    @Provides
    fun provideApiService(): ApiService {

        return Retrofit
            .Builder()
            .baseUrl("https://the-mexican-food-db.p.rapidapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    fun providesFoodDataProvider(apiService: ApiService): FoodDataProviders{
        return FoodDataProviders(apiService)
    }

}