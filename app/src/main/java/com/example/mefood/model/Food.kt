package com.example.mefood.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Food (
    @StringRes val name: Int,
    @DrawableRes val image: Int,
    @StringRes val culturalOrigin: Int,
    @StringRes val description: Int,
    val isVegetarian: Boolean
)