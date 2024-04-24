package com.example.playground.animalfacts.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.playground.animalfacts.viewstate.AnimalFactsScreenViewState
import com.example.playground.shared.ui.theme.PlaygroundTheme

/*
* Composable Screen for Animal Facts
* */
@Composable
fun AnimalFactsScreen(animalFactsScreenViewState: AnimalFactsScreenViewState) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        Text(text = animalFactsScreenViewState.text)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PlaygroundTheme {
        AnimalFactsScreen(AnimalFactsScreenViewState("Animal Fact"))
    }
}