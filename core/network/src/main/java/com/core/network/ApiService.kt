package com.core.network

import com.core.network.models.FoodDetailsDTO
import com.core.network.models.FoodListResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

/**
 * [Api Documentation](https://rapidapi.com/rapihub-rapihub-default/api/the-mexican-food-db/)
 */

interface ApiService {

    @Headers(
        "X-RapidAPI-Key: f3e937b351msh7645c07e5ecaa81p1ec214jsn4eaa57bdb635",
        "X-RapidAPI-Host: the-mexican-food-db.p.rapidapi.com"
    )
    @GET("/")
    suspend fun getFoodList(): FoodListResponse

    @Headers(
        "X-RapidAPI-Key: f3e937b351msh7645c07e5ecaa81p1ec214jsn4eaa57bdb635",
        "X-RapidAPI-Host: the-mexican-food-db.p.rapidapi.com"
    )
    @GET("{foodId}")
    suspend fun getFoodDetails(@Path("foodId") foodId: String): FoodDetailsDTO


}