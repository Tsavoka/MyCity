package com.example.mycity.data

import com.example.mycity.model.CategoryItem

data class MyCityUiState(
    val categoryList: List<CategoryItem> = emptyList(),
    val currentPlace: CategoryItem = DataSource.getCoffee()[0],
)
