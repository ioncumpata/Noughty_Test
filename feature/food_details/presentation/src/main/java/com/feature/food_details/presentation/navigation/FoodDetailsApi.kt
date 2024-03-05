package com.feature.food_details.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.core.feature_api.FeatureApi

interface FoodDetailsApi: FeatureApi {

}

class FoodDetailsApiImpl: FoodDetailsApi{
    override fun registerGraph(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
        InternalFoodDetailsApi.registerGraph(navController, navGraphBuilder)
    }

}