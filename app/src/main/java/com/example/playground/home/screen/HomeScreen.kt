package com.example.playground.home.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.playground.shared.ui.theme.PlaygroundTheme

/*
* Composable Screen for Home Fragment
* */
@Composable
fun HomeScreen(name: String) {
    PlaygroundTheme {
        // A surface container using the 'background' color from the theme
        Column(
            modifier = Modifier.fillMaxSize().background(Color.White),
        ) {
            Greeting(name)
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PlaygroundTheme {
        Greeting("Android")
    }
}