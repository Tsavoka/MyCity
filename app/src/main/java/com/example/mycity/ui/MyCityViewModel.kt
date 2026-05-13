package com.example.mycity.ui

import androidx.lifecycle.ViewModel
import com.example.mycity.data.DataSource
import com.example.mycity.data.MyCityUiState
import com.example.mycity.model.CategoryItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class MyCityViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        MyCityUiState(
            categoryList = DataSource.getCategories(),
            currentPlace = DataSource.getCoffee().getOrElse(0) {
                DataSource.getCoffee()[0]
            }
        )
    )

    val uiState: StateFlow<MyCityUiState> = _uiState

    fun updateCurrentCategory(selectedCategory: List<CategoryItem>) {
        _uiState.update {
            it.copy(categoryList = selectedCategory)
        }
    }

    fun updateCurrentPlace(selectedPlace: CategoryItem) {
        _uiState.update {
            it.copy(currentPlace = selectedPlace)
        }
    }
}