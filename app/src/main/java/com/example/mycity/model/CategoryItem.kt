package com.example.mycity.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class CategoryItem (
    @StringRes val titleResourceId: Int,
    @StringRes val subtitleResourceId: Int,
    @DrawableRes val imageResourceId: Int
)