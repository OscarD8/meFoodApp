package com.example.mefood.model

import androidx.compose.ui.res.stringResource
import com.example.mefood.R

object FoodRepository {
    val foods = listOf<Food>(
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