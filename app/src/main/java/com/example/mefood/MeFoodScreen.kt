package com.example.mefood

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mefood.data.Datasource
import com.example.mefood.ui.MenuScreen
import com.example.mefood.ui.HomeScreen

enum class MeFoodScreen(@StringRes val title: Int) {
    Home(R.string.app_name),
    Starter(R.string.starter_header)
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

@Composable
fun MeFoodApp() {
    val navController: NavHostController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = MeFoodScreen.valueOf(
        backStackEntry?.destination?.route ?: MeFoodScreen.Home.name
    )

    Scaffold (
        topBar = { TopAppBar(
            meFoodScreen = currentScreen
        ) },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = MeFoodScreen.Home.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = MeFoodScreen.Home.name) {
                HomeScreen(
                    onClick = { navController.navigate(MeFoodScreen.Starter.name) },
                    modifier = Modifier.fillMaxSize()
                )
            }

            composable(route = MeFoodScreen.Starter.name) {
                MenuScreen(
                    foods = Datasource.foods
                )
            }
        }
    }
}