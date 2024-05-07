package com.example.playground.animalfacts.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
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
import androidx.compose.ui.unit.dp
import com.example.playground.R
import com.example.playground.animalfacts.screen.AnimalFactsScreenValues.textPaddingValues
import com.example.playground.animalfacts.viewstate.AnimalFactsScreenViewState
import com.example.playground.animalfacts.viewstate.BackButtonViewState
import com.example.playground.shared.ui.theme.PlaygroundTheme

/*
* Composable Screen for Animal Facts
* */
object AnimalFactsScreenValues {
    val textPaddingValues = PaddingValues(horizontal = 20.dp)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimalFactsScreen(animalFactsScreenViewState: AnimalFactsScreenViewState) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.animal_facts_title)) },
                navigationIcon = {
                    IconButton(onClick = animalFactsScreenViewState.backButtonViewState.onClick) {
                        Icon(
                            imageVector = animalFactsScreenViewState.backButtonViewState.icon,
                            contentDescription = animalFactsScreenViewState.backButtonViewState.contentDescription
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color.White)
                .wrapContentSize(Alignment.Center),
        ) {
            Text(
                modifier = Modifier.padding(textPaddingValues),
                text = animalFactsScreenViewState.text
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PlaygroundTheme {
        AnimalFactsScreen(
            AnimalFactsScreenViewState(
                "Animal Fact",
                backButtonViewState = BackButtonViewState(onClick = {})
            )
        )
    }
}