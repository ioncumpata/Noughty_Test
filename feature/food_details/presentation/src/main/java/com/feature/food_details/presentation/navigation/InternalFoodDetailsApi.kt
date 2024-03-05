package com.feature.food_details.presentation.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.core.common.navigation_constants.FoodDetailsFeature
import com.core.feature_api.FeatureApi
import com.feature.food_details.presentation.screen.FoodDetailsScreen
import com.feature.food_details.presentation.screen.FoodDetailsViewModel

internal object InternalFoodDetailsApi: FeatureApi {
    override fun registerGraph(navController: NavHostController, navGraphBuilder: NavGraphBuilder) {
        navGraphBuilder.navigation(startDestination = FoodDetailsFeature.foodDetailsScreenRoute , route = FoodDetailsFeature.nestedRoute){
            composable(FoodDetailsFeature.foodDetailsScreenRoute){
                val viewModel = hiltViewModel<FoodDetailsViewModel>()
                    FoodDetailsScreen(viewModel = viewModel)


            }
        }
    }
}