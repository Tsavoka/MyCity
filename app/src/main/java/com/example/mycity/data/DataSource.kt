package com.example.mycity.data

import com.example.mycity.R
import com.example.mycity.model.CategoryItem


object DataSource {
    fun getCategories(): List<CategoryItem> {
        return listOf(
            CategoryItem(
                titleResourceId = R.string.category_coffee,
                subtitleResourceId = R.string.details_coffee,
                imageResourceId = R.drawable.cat_cof,
            ),
            CategoryItem(
                titleResourceId = R.string.category_restaurants,
                subtitleResourceId = R.string.details_restaurant,
                imageResourceId = R.drawable.cat_rest,
            ),
            CategoryItem(
                titleResourceId = R.string.category_kidfriendly,
                subtitleResourceId = R.string.details_kidfriendly,
                imageResourceId = R.drawable.cat_kids,
            ),
            CategoryItem(
                titleResourceId = R.string.category_parks,
                subtitleResourceId = R.string.details_park,
                imageResourceId = R.drawable.cat_park,
            ),
            CategoryItem(
                titleResourceId = R.string.category_shopping,
                subtitleResourceId = R.string.details_shopping,
                imageResourceId = R.drawable.cat_shop,
            )
        )
    }

    fun getCoffee(): List<CategoryItem> {
        return listOf(
            CategoryItem(
                titleResourceId = R.string.coffee1,
                subtitleResourceId = R.string.details_coffee1,
                imageResourceId = R.drawable.cof1,
            ),
            CategoryItem(
                titleResourceId = R.string.coffee2,
                subtitleResourceId = R.string.details_coffee2,
                imageResourceId = R.drawable.cof2,
            ),
            CategoryItem(
                titleResourceId = R.string.coffee3,
                subtitleResourceId = R.string.details_coffee3,
                imageResourceId = R.drawable.cof3,
            ),
            CategoryItem(
                titleResourceId = R.string.coffee4,
                subtitleResourceId = R.string.details_coffee4,
                imageResourceId = R.drawable.cof4,
            ),
            CategoryItem(
                titleResourceId = R.string.coffee5,
                subtitleResourceId = R.string.details_coffee5,
                imageResourceId = R.drawable.cof5,
            )
        )
    }

    fun getRestaurants(): List<CategoryItem> {
        return listOf(
            CategoryItem(
                titleResourceId = R.string.restaurant1,
                subtitleResourceId = R.string.details_restaurant1,
                imageResourceId = R.drawable.rest1,
            ),
            CategoryItem(
                titleResourceId = R.string.restaurant2,
                subtitleResourceId = R.string.details_restaurant2,
                imageResourceId = R.drawable.rest2,
            ),
            CategoryItem(
                titleResourceId = R.string.restaurant3,
                subtitleResourceId = R.string.details_restaurant3,
                imageResourceId = R.drawable.rest3,
            )
        )
    }

    fun getKidfriendly(): List<CategoryItem> {
        return listOf(
            CategoryItem(
                titleResourceId = R.string.kidfriendly1,
                subtitleResourceId = R.string.details_kidfriendly1,
                imageResourceId = R.drawable.kids,
            )
        )
    }

    fun getParks(): List<CategoryItem> {
        return listOf(
            CategoryItem(
                titleResourceId = R.string.park1,
                subtitleResourceId = R.string.details_park1,
                imageResourceId = R.drawable.park1,
            ),
            CategoryItem(
                titleResourceId = R.string.park2,
                subtitleResourceId = R.string.details_park2,
                imageResourceId = R.drawable.park2,
            ),
            CategoryItem(
                titleResourceId = R.string.park3,
                subtitleResourceId = R.string.details_park3,
                imageResourceId = R.drawable.park3,
            ),
            CategoryItem(
                titleResourceId = R.string.park4,
                subtitleResourceId = R.string.details_park4,
                imageResourceId = R.drawable.park4,
            )
        )
    }

    fun getShopping(): List<CategoryItem> {
        return listOf(
            CategoryItem(
                titleResourceId = R.string.shopping1,
                subtitleResourceId = R.string.details_shopping1,
                imageResourceId = R.drawable.shop1,
            ),
            CategoryItem(
                titleResourceId = R.string.shopping2,
                subtitleResourceId = R.string.details_shopping2,
                imageResourceId = R.drawable.shop2,
            )
        )
    }
}
