package com.example.mefood.ui

import FullCircleShape
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mefood.R
import com.example.mefood.ui.theme.AppTheme

@Composable
fun HomeScreen(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .verticalScroll(rememberScrollState())
    ) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .size(dimensionResource(R.dimen.home_logo_width))
                .aspectRatio(1f)
        )
        FilledTonalButton(
            onClick = onClick,
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth(0.5f),
            ) {
            Text(
                text = stringResource(R.string.start_order_button_text),
                style = MaterialTheme.typography.displaySmall,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview
@Composable
private fun PreviewHome() {
    AppTheme {
        HomeScreen(
            onClick = {},
            modifier = Modifier.fillMaxSize()
        )
    }
}