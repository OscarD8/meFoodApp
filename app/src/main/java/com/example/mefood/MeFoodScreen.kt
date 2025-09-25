package com.example.mefood

import android.content.Context
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bento
import androidx.compose.material.icons.filled.Dining
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Icecream
import androidx.compose.material.icons.filled.RamenDining
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mefood.data.Datasource
import com.example.mefood.ui.HomeScreen
import com.example.mefood.ui.MenuScreen

enum class MeFoodScreen(
    @StringRes val title: Int,
    val icon: ImageVector
) {
    Home(R.string.home_header, Icons.Default.Home),
    Starter(R.string.starter_header, Icons.Default.Bento),
    Main(R.string.main_header, Icons.Default.RamenDining),
    Dessert(R.string.dessert_header, Icons.Default.Icecream)
}


@Composable
private fun MeFoodNavBar(
    selectedDestination: Int,
    onNavigationChange: (Int, MeFoodScreen) -> Unit,
) {

    NavigationBar(
        windowInsets = NavigationBarDefaults.windowInsets,
        modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_medium))
        ) {
        MeFoodScreen.entries.forEachIndexed { index, destination ->
            NavigationBarItem(
                selected = selectedDestination == index,
                onClick = {
                    onNavigationChange(destination.ordinal, destination)
                },
                icon = {
                    Icon(
                        destination.icon,
                        contentDescription = destination.name
                    ) },
                label = {
                    Text(
                        text = stringResource(destination.title)
                    )
                }
            )
        }
    }
}

@Composable
fun MeFoodApp() {
    val navController: NavHostController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = MeFoodScreen.valueOf(
        backStackEntry?.destination?.route ?: MeFoodScreen.Home.name
    )
    var selectedDestination by rememberSaveable { mutableIntStateOf(currentScreen.ordinal) }


    Scaffold (
        bottomBar = {
            MeFoodNavBar(
                selectedDestination = selectedDestination,
                onNavigationChange = { newIndex, newScreen ->
                    selectedDestination = newIndex
                    navController.navigate(newScreen.name)
                }
            )
        },
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = MeFoodScreen.Home.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            MeFoodScreen.entries.forEach { destination ->
                composable(route = destination.name) {
                    when (destination) {
                        MeFoodScreen.Home -> HomeScreen(
                            onClick = {
                                navController.navigate(MeFoodScreen.Starter.name)
                                selectedDestination = MeFoodScreen.Starter.ordinal
                            },
                            modifier = Modifier.fillMaxSize()
                        )
                        MeFoodScreen.Starter -> MenuScreen(
                            menuItems = Datasource.starterMenuItems,
                        )
                        MeFoodScreen.Main -> MenuScreen(
                            menuItems = Datasource.mainMenuItems
                        )
                        MeFoodScreen.Dessert -> MenuScreen(
                            menuItems = Datasource.dessertMenuItems
                        )
                    }
                }
            }
        }
    }
}