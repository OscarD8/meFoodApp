package com.example.mefood

import android.content.Context
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bento
import androidx.compose.material.icons.filled.Home
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
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHost
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
    @StringRes val route: Int,
    val icon: ImageVector
) {
    Home(R.string.app_name, R.string.home_route_name, Icons.Default.Home),
    Starter(R.string.starter_header, R.string.starter_route_name, Icons.Default.Bento)
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopAppBar(
    meFoodScreen: MeFoodScreen,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(meFoodScreen.title),
                style = MaterialTheme.typography.headlineLarge
            )
        },
        modifier = modifier
    )
}

//@Composable
//private fun BottomNavBar(
//    navController: NavHostController,
//    context: Context
//) {
//    val startDestination = MeFoodScreen.Home
//    var selectedDestination by rememberSaveable { mutableIntStateOf(startDestination.ordinal) }
//
//
//    NavigationBar(windowInsets = NavigationBarDefaults.windowInsets) {
//        MeFoodScreen.entries.forEachIndexed { index, destination ->
//            NavigationBarItem(
//                selected = selectedDestination == index,
//                onClick = {
//                    navController.navigate(route = context.getString(destination.route))
//                },
//                icon = {
//                    Icon(
//                        destination.icon,
//                        contentDescription = null // TODO
//                    )
//                }
//            )
//        }
//    }
//}

@Composable
fun MeFoodApp() {
    val navController: NavHostController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = MeFoodScreen.valueOf(
        backStackEntry?.destination?.route ?: MeFoodScreen.Home.name
    )

    Scaffold (
        topBar = { TopAppBar(meFoodScreen = currentScreen) },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        val context = LocalContext.current

        NavHost(
            navController = navController,
            startDestination = MeFoodScreen.Home.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            MeFoodScreen.entries.forEach { destination ->
                composable(context.resources.getString(destination.route)) {
                    when (destination) {
                        MeFoodScreen.Home -> HomeScreen(
                            onClick = { navController.navigate(MeFoodScreen.Starter) },
                            modifier = Modifier.fillMaxSize()
                        )
                        MeFoodScreen.Starter -> MenuScreen(
                            foods = Datasource.foods,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }
        }
    }
}