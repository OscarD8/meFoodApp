package com.example.mefood.data

import com.example.mefood.R
import com.example.mefood.model.MenuItem.MainItem
import com.example.mefood.model.MenuItem.StarterItem
import com.example.mefood.model.MenuItem.DessertItem


object Datasource {
    val mainMenuItems = listOf(
        MainItem(
            name = R.string.gaeng_som_meal_name,
            image = R.drawable.salmon_curry,
            culturalOrigin = R.string.origin_thai,
            description = R.string.gaeng_som_meal_desc,
            price = 12.00,
            isVegetarian = false
        ),
        MainItem(
            name = R.string.vege_fiesta_meal_name,
            image = R.drawable.vege_fiesta,
            culturalOrigin = R.string.origin_mexico,
            description = R.string.vege_fiesta_meal_desc,
            price = 9.50,
            isVegetarian = true
        )
    )

    val starterMenuItems = listOf(
        StarterItem(
            name = R.string.som_tum_name,
            image = R.drawable.som_tum,
            culturalOrigin = R.string.origin_thai,
            description = R.string.som_tum_desc,
            price = 3.50,
            isVegetarian = true
        ),
        StarterItem(
            name = R.string.tod_mun_plaa_name,
            image = R.drawable.tod_mun_plaa,
            culturalOrigin = R.string.origin_thai,
            description = R.string.tod_mun_plaa_desc,
            price = 6.80,
            isVegetarian = false
        )
    )

    val dessertMenuItems = listOf(
        DessertItem(
            name = R.string.coconut_panna_cotta_name,
            image = R.drawable.panacotta,
            culturalOrigin = R.string.origin_italy,
            description = R.string.coconut_panna_cotta_desc,
            price = 4.00,
            isVegetarian = true
        ),
        DessertItem(
            R.string.mango_sticky_rice_name,
            R.drawable.mangostickyrice,
            R.string.origin_thai,
            R.string.mango_sticky_rice_desc,
            4.20,
            true
        )
    )
}