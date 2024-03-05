package com.feature.food.presentation.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.feature.food.domain.models.Food

@Composable
fun FoodScreen(viewModel: FoodViewModel, navController: NavController) {

    val foodScreenState = viewModel.foodList.value

    when {
        foodScreenState.isLoading -> LoadingScreen()
        foodScreenState.data != null -> FoodListScreen(data = foodScreenState.data, navController)
        foodScreenState.error.isNotEmpty() -> ErrorScreen(errorMessage = foodScreenState.error)
    }


}

@Composable
fun FoodListScreen(data: List<Food>, navController: NavController) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(data.size) { item ->
            FoodItemCard(data[item], navController)
        }
    }
}

@Composable
fun FoodItemCard(item: Food, navController: NavController) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .clickable { navController.navigate("food_details/${item.id}") }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            AsyncImage(
                model = item.image,
                contentDescription = "Movie Poster",
                modifier = Modifier
                    .fillMaxSize()
            )
            Text(text = item.title, fontWeight = FontWeight.Bold)
            Text(text = "Difficulty: ${item.difficulty}")
        }
    }
}

@Composable
fun LoadingScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorScreen(errorMessage: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Error!",
                color = Color.Red,
                fontSize = MaterialTheme.typography.bodyLarge.fontSize
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = errorMessage)
        }
    }
}