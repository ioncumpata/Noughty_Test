package dev.cumpataion.noughtytest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.core.common.navigation_constants.FoodFeature

@Composable
fun AppNavGraph(
    navController: NavHostController,
    navigationProvider: NavigationProvider,
){
    NavHost(navController = navController, startDestination = FoodFeature.nestedRoute ){
        navigationProvider.foodApi.registerGraph(
            navController,this
        )

        navigationProvider.foodDetailsApi.registerGraph(
            navController,this
        )
    }
}