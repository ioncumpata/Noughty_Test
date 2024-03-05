package com.feature.food_details.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.feature.food_details.domain.models.FoodDetails

@Composable
fun FoodDetailsScreen( viewModel: FoodDetailsViewModel) {

    val foodDetailsScreenState = viewModel.foodDetails.value

    when {
        foodDetailsScreenState.isLoading -> LoadingScreen()
        foodDetailsScreenState.data != null -> FoodScreen(foodDetails = foodDetailsScreenState.data)
        foodDetailsScreenState.error.isNotEmpty() -> ErrorScreen(errorMessage = foodDetailsScreenState.error)
    }

}


@Composable
fun FoodScreen(foodDetails: FoodDetails) {
    Column(modifier = Modifier.fillMaxSize()) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            contentDescription = foodDetails.title,
            model = foodDetails.image
        )
        Text(
            modifier = Modifier.padding(16.dp),
            text = foodDetails.title,
            style = MaterialTheme.typography.headlineLarge
        )
        Text(
            text = "Difficulty: ${foodDetails.difficulty}",
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Text(text = foodDetails.portion, modifier = Modifier.padding(horizontal = 16.dp))
        Text(
            text = foodDetails.time,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
        HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
        Text(
            text = "Ingredients:",
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
        val bulletedIngredients = remember { foodDetails.ingredients.map { "* $it" } }
        LazyColumn(modifier = Modifier.padding(horizontal = 16.dp)) {
            items(bulletedIngredients.size) { item ->
                Text(text = bulletedIngredients[item])
            }
        }
        HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp))
        Text(
            text = "Instructions:",
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
        LazyColumn(modifier = Modifier.padding(horizontal = 16.dp)) {
            items(foodDetails.method.size) { index ->
                val step = foodDetails.method[index]
                Text(
                    text = "Step ${index + 1}: ${step}",
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
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