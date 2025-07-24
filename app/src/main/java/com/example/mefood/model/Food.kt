package com.example.mefood.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

enum class MealType {
    STARTER,
    MAIN,
    DESSERT
}
data class Food (
    @StringRes val name: Int,
    @DrawableRes val image: Int,
    @StringRes val culturalOrigin: Int,
    @StringRes val description: Int,
    val mealType: MealType,
    val isVegetarian: Boolean
)

