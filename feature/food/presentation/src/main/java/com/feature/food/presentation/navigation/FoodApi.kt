package com.feature.food.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.core.feature_api.FeatureApi

interface FoodApi: FeatureApi {

}

class FoodApiImpl(): FoodApi{
    override fun registerGraph(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
        InternalFoodFeatureApi.registerGraph(
            navController,navGraphBuilder
        )
    }

}