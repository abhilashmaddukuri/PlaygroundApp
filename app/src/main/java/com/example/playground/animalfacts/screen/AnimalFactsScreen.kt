package com.example.playground.animalfacts.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
fun AnimalFactsScreen(viewState: AnimalFactsScreenViewState) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.animal_facts_title)) },
                navigationIcon = {
                    IconButton(onClick = viewState.backButtonViewState.onClick) {
                        Icon(
                            imageVector = viewState.backButtonViewState.icon,
                            contentDescription = viewState.backButtonViewState.contentDescription
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        val modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Color.White)
            .wrapContentSize(Alignment.Center)
        if (viewState.isLoading) {
            AnimalFactsLoading(
                modifier = modifier
            )
        } else if (viewState.isError) {
            AnimalFactsError(modifier)
        }else {
            AnimalFactsContainer(
                modifier = modifier,
                viewState = viewState,
            )
        }
    }
}

@Composable
fun AnimalFactsError(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier.padding(textPaddingValues),
        text = stringResource(id = R.string.animal_facts_api_error_message),
        color = Color.Red
    )
}

@Composable
fun AnimalFactsLoading(modifier: Modifier = Modifier) {
    Column(modifier = modifier.background(Color.White)) {
        CircularProgressIndicator(
            modifier = modifier
                .size(64.dp),
            color = MaterialTheme.colorScheme.secondary,
            trackColor = MaterialTheme.colorScheme.surfaceVariant,
        )
        Text(
            modifier = Modifier.padding(top = 10.dp),
            text = stringResource(id = R.string.animal_facts_api_loading_message),
        )
    }
}

@Composable
fun AnimalFactsContainer(
    modifier: Modifier = Modifier,
    viewState: AnimalFactsScreenViewState,
) {
    Column(
        modifier = modifier,
    ) {
        viewState.text?.let {
            Text(
                modifier = Modifier.padding(textPaddingValues),
                text = it
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
                isLoading = false,
                isError = false,
                text = "Animal Fact",
                backButtonViewState = BackButtonViewState(onClick = {})
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
                text = null,
                backButtonViewState = BackButtonViewState(onClick = {})
            )
        )
    }
}