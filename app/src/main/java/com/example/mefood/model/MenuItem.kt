package com.example.mefood.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


sealed class MenuItem(
    @StringRes open val name: Int,
    @DrawableRes open val image: Int,
    @StringRes open val culturalOrigin: Int,
    @StringRes open val description: Int,
    open val price: Double,
    open val isVegetarian: Boolean
) {
    data class StarterItem(
        @StringRes override val name: Int,
        @DrawableRes override val image: Int,
        @StringRes override val culturalOrigin: Int,
        @StringRes override val description: Int,
        override val price: Double,
        override val isVegetarian: Boolean
    ) : MenuItem(name, image, culturalOrigin, description, price,isVegetarian)

    data class MainItem(
        @StringRes override val name: Int,
        @DrawableRes override val image: Int,
        @StringRes override val culturalOrigin: Int,
        @StringRes override val description: Int,
        override val price: Double,
        override val isVegetarian: Boolean
    ) : MenuItem(name, image, culturalOrigin, description, price,isVegetarian)

    data class DessertItem(
        @StringRes override val name: Int,
        @DrawableRes override val image: Int,
        @StringRes override val culturalOrigin: Int,
        @StringRes override val description: Int,
        override val price: Double,
        override val isVegetarian: Boolean
    ) : MenuItem(name, image, culturalOrigin, description, price,isVegetarian)
}

