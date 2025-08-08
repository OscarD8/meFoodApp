package com.example.mefood.data

import com.example.mefood.R
import com.example.mefood.model.Food
import com.example.mefood.model.MealType

object Datasource {
    val foods = listOf(
        Food(
            name = R.string.gaeng_som_meal_name,
            image = R.drawable.salmon_curry,
            culturalOrigin = R.string.origin_thai,
            description = R.string.gaeng_som_meal_desc,
            mealType = MealType.MAIN,
            isVegetarian = false
        ),
        Food(
            name = R.string.vege_fiesta_meal_name,
            image = R.drawable.vege_fiesta,
            culturalOrigin = R.string.origin_mexico,
            description = R.string.vege_fiesta_meal_desc,
            mealType = MealType.MAIN,
            isVegetarian = true
        )
    )
}