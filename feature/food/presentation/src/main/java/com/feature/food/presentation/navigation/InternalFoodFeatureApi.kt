package com.feature.food.presentation.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.core.common.navigation_constants.FoodFeature
import com.core.feature_api.FeatureApi
import com.feature.food.presentation.screen.FoodScreen
import com.feature.food.presentation.screen.FoodViewModel

internal object InternalFoodFeatureApi: FeatureApi {
    override fun registerGraph(
        navController: NavHostController,
        navGraphBuilder: NavGraphBuilder
    ) {
        navGraphBuilder.navigation(startDestination = FoodFeature.foodScreenRoute, route = FoodFeature.nestedRoute){
            composable(FoodFeature.foodScreenRoute){

                val viewModel = hiltViewModel<FoodViewModel>()
                FoodScreen(viewModel = viewModel, navController)

            }
        }
    }
}