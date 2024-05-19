package com.example.playground.animalfacts.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.playground.R
import com.example.playground.animalfacts.screen.AnimalFactsScreenValues.containerPaddingValues
import com.example.playground.animalfacts.screen.AnimalFactsScreenValues.progressIndicatorSize
import com.example.playground.animalfacts.viewstate.AnimalFactsScreenViewState
import com.example.playground.shared.ui.theme.PlaygroundTheme
import com.example.playground.shared.view.screen.PlaygroundIconButton
import com.example.playground.shared.view.viewstate.PlaygroundIconButtonViewState

/*
* Composable Screen for Animal Facts
* */
object AnimalFactsScreenValues {
    val containerPaddingValues = PaddingValues(horizontal = 20.dp)
    val progressIndicatorSize = 64.dp
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimalFactsScreen(viewState: AnimalFactsScreenViewState) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.animal_facts_title)) },
                navigationIcon = {
                    PlaygroundIconButton(viewState = viewState.backButtonViewState)
                },
                actions = {
                    PlaygroundIconButton(viewState = viewState.refreshButtonViewState)
                }
            )
        }
    ) { innerPadding ->
        val modifier = Modifier
            .padding(innerPadding)
            .background(Color.White)
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
        if (viewState.isLoading) {
            AnimalFactsLoading(modifier = modifier)
        } else if (viewState.isError) {
            AnimalFactsError(modifier = modifier)
        } else {
            AnimalFactsContainer(modifier = modifier, viewState = viewState)
        }
    }
}

@Composable
fun AnimalFactsError(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier.padding(containerPaddingValues),
        text = stringResource(id = R.string.animal_facts_api_error_message),
        color = Color.Red
    )
}

@Composable
fun AnimalFactsLoading(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        CircularProgressIndicator(
            modifier = modifier
                .size(progressIndicatorSize),
            color = MaterialTheme.colorScheme.secondary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant,
        )
    }
}

@Composable
fun AnimalFactsContainer(
    modifier: Modifier = Modifier,
    viewState: AnimalFactsScreenViewState,
) {
    Column(
        modifier = modifier
            .padding(containerPaddingValues),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        viewState.fact?.let { fact ->
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = fact,
                textAlign = TextAlign.Center,
                color = Color.DarkGray
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AnimalFactsPreview() {
    PlaygroundTheme {
        AnimalFactsScreen(
            AnimalFactsScreenViewState(
                isLoading = true,
                isError = false,
                fact = "Animal Fact",
                backButtonViewState = PlaygroundIconButtonViewState(
                    icon = R.drawable.ic_back,
                    onClick = {}
                ),
                refreshButtonViewState = PlaygroundIconButtonViewState(
                    icon = R.drawable.ic_refresh,
                    onClick = {}
                )
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun AnimalFactsLoaderPreview() {
    PlaygroundTheme {
        AnimalFactsLoading()
    }
}

@Preview(showBackground = true)
@Composable
private fun AnimalFactsErrorPreview() {
    PlaygroundTheme {
        AnimalFactsScreen(
            AnimalFactsScreenViewState(
                isLoading = false,
                isError = true,
                fact = null,
                backButtonViewState = PlaygroundIconButtonViewState(
                    icon = R.drawable.ic_back,
                    onClick = {}
                ),
                refreshButtonViewState = PlaygroundIconButtonViewState(
                    icon = R.drawable.ic_refresh,
                    onClick = {}
                )
            )
        )
    }
}