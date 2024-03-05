package com.feature.food_details.presentation.screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.core.common.Resource
import com.feature.food_details.domain.use_cases.GetFoodDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class FoodDetailsViewModel @Inject constructor(
    private val getFoodDetailsUseCase: GetFoodDetailsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _foodDetails = mutableStateOf(FoodDetailsScreenState())
    val foodDetails: State<FoodDetailsScreenState> get() = _foodDetails

    init{
        savedStateHandle.getLiveData<String>("id").observeForever{
            it?.let {
                getFoodDetails(it)
            }
        }
    }


    private fun getFoodDetails(id: String){

        getFoodDetailsUseCase(id).onEach {
            when(it){

                is Resource.Loading ->{

                    _foodDetails.value = FoodDetailsScreenState(isLoading = true)
                }
                is Resource.Success ->{

                    _foodDetails.value =  FoodDetailsScreenState(data = it.data)

                }
                is Resource.Error ->{

                    _foodDetails.value =  FoodDetailsScreenState(error = it.message.toString())

                }
            }
        }.launchIn(viewModelScope)
    }
}