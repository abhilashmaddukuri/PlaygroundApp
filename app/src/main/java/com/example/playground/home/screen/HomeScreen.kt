package com.example.playground.home.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.playground.R
import com.example.playground.home.viewstate.HomeScreenViewState
import com.example.playground.shared.ui.theme.PlaygroundTheme

/*
* Composable Screen for Home Fragment
* */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun HomeScreen(homeScreenViewState: HomeScreenViewState) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.app_name)) },
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .wrapContentSize(Alignment.Center)
                .padding(innerPadding),
        ) {
            Button(onClick = homeScreenViewState.buttonClick ?: {}) {
                Text(text = homeScreenViewState.buttonText)
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun GreetingPreview() {
    PlaygroundTheme {
        HomeScreen(HomeScreenViewState("Android", {} ))
    }
}