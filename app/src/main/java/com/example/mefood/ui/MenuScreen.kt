package com.example.mefood.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mefood.R
import com.example.mefood.model.MenuItem
import com.example.mefood.ui.theme.AppTheme

@Composable
fun MenuScreen(
    menuItems: List<MenuItem>,
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
            itemsIndexed(menuItems) { index, menuItem ->
                FoodListItem(
                    menuItem = menuItem,
                    modifier = Modifier
                        .padding(
                            horizontal = dimensionResource(R.dimen.padding_large),
                            vertical = dimensionResource(R.dimen.padding_medium)
                        )
                        .animateEnterExit(
                            enter = slideInVertically(
                                animationSpec = spring(
                                    dampingRatio = Spring.DampingRatioLowBouncy,
                                    stiffness = Spring.StiffnessLow
                                ),
                                initialOffsetY = { it * (index + 1) }
                            )
                        )
                )
            }
        }
    }
}

@Composable
private fun FoodListItem(
    menuItem: MenuItem,
    modifier: Modifier = Modifier
) {
    var isExpanded by remember { mutableStateOf(false) }
    val animateColor by animateColorAsState(
        targetValue = if (isExpanded) MaterialTheme.colorScheme.surfaceContainerLow else MaterialTheme.colorScheme.surfaceContainerHigh
    )

    Card(
        elevation = CardDefaults.cardElevation(dimensionResource(R.dimen.shadow_small)),
        shape = MaterialTheme.shapes.large,
        colors = CardDefaults.cardColors(animateColor),
        modifier = modifier
    ) {
        Column (
            modifier = Modifier
                .padding(dimensionResource(R.dimen.padding_large))
                .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .sizeIn(minHeight = dimensionResource(R.dimen.row_min_height)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
                    modifier = Modifier
                        .weight(1f)
                ) {
                    Text(
                        text = stringResource(menuItem.name),
                        style = MaterialTheme.typography.labelLarge
                    )
                    Text(
                        text = stringResource(menuItem.culturalOrigin),
                        style = MaterialTheme.typography.bodyMedium
                    )
                }

                FoodInfoIcon(isExpanded) { isExpanded = isExpanded.not() }

                Spacer(modifier = Modifier.width(dimensionResource(R.dimen.padding_large)))

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(dimensionResource(R.dimen.box_size))
                ) {
                    Image(
                        painter = painterResource(menuItem.image),
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .shadow(
                                elevation = dimensionResource(R.dimen.shadow_small),
                                shape = MaterialTheme.shapes.large
                            )
                    )
                }
            }
            if (isExpanded) {
                Text(
                    text = stringResource(menuItem.description),
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Justify,
                    modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
                )
            }
        }
    }
}

@Composable
private fun FoodInfoIcon(
    isExpanded: Boolean,
    onInfoButtonClick: () -> Unit
) {
    IconButton (
        onClick = onInfoButtonClick
    ) {
        Icon(
            imageVector = if (isExpanded) Icons.Outlined.Info else Icons.Filled.Info,
            contentDescription = stringResource(R.string.info_prompt)
        )
    }
}

@Preview
@Composable
fun PreviewCard() {
    AppTheme {
        FoodListItem(
            menuItem = MenuItem.StarterItem(
                name = R.string.gaeng_som_meal_name,
                image = R.drawable.salmon_curry,
                culturalOrigin = R.string.origin_thai,
                description = R.string.gaeng_som_meal_desc,
                price = 10.00,
                isVegetarian = false
            )
        )
    }
}

