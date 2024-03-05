package com.feature.food.presentation.screen


import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.common.Resource
import com.feature.food.domain.use_cases.GetFoodListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodViewModel @Inject constructor(
    private val getFoodListUseCase: GetFoodListUseCase,
) : ViewModel() {


    private val _foodList = mutableStateOf(FoodScreenState())
    val foodList: State<FoodScreenState> get() = _foodList

    init {
        viewModelScope.launch {
            getFoodList()

        }
    }


    private fun getFoodList() {

        getFoodListUseCase().onEach {
            when (it) {

                is Resource.Loading -> {

                    _foodList.value = FoodScreenState(isLoading = true)
                }

                is Resource.Success -> {

                    _foodList.value = FoodScreenState(data = it.data)

                }

                is Resource.Error -> {

                    _foodList.value = FoodScreenState(error = it.message.toString())

                }
            }
        }.launchIn(viewModelScope)
    }

}