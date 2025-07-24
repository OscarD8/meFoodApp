package com.example.mefood

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mefood.model.FoodRepository
import com.example.mefood.ui.theme.AppTheme
import com.example.mefood.ui.theme.MeFoodTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MeFoodApp(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}

@Composable
fun MeFoodApp(modifier: Modifier = Modifier) {
    Scaffold (
        topBar = { TopAppBar() },
        modifier = Modifier.fillMaxSize()
    ) {
        FoodList(
            foods = FoodRepository.foods,
            contentPadding = it,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopAppBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.titleLarge
            )
        }
    )
}

@Preview
@Composable
fun PreviewMeFoodApp() {
    AppTheme {
        MeFoodApp(
            modifier = Modifier.fillMaxSize()
        )
    }
}