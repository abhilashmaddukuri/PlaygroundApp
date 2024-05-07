package com.example.playground.home.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.playground.home.viewstate.HomeScreenViewState
import com.example.playground.shared.ui.theme.PlaygroundTheme

/*
* Composable Screen for Home Fragment
* */
@Composable
internal fun HomeScreen(homeScreenViewState: HomeScreenViewState) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .wrapContentSize(Alignment.Center),
    ) {
        Button(onClick = homeScreenViewState.buttonClick ?: {}) {
            Text(text = homeScreenViewState.buttonText)
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