package com.example.mefood

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.example.mefood.model.Food

@Composable
fun FoodList(
    foods: List<Food>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    val visibleState = remember {
        MutableTransitionState(false).apply{
            targetState = true
        }
    }

    AnimatedVisibility(
        visibleState = visibleState,

        enter = fadeIn(animationSpec = spring(
            dampingRatio = Spring.DampingRatioLowBouncy
            )
        ),
        exit = fadeOut(),
        modifier = modifier
    ) {
        LazyColumn (contentPadding = contentPadding) {
            itemsIndexed(foods) { index, food ->
                FoodListItem(
                    food = food,
                    modifier = Modifier
                        .padding(dimensionResource(R.dimen.padding_large))
                        .animateEnterExit(
                            enter =
                        )
                )
            }
        }
    }
}

@Composable
private fun FoodListItem(
    food: Food,
    modifier: Modifier = Modifier
) {
    Card (modifier = modifier) {
        Row (
            modifier = Modifier.fillMaxWidth()
        ) {

        }
    }
}