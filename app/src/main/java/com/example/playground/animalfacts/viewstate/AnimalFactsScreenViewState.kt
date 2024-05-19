package com.example.playground.animalfacts.viewstate

import com.example.playground.shared.view.viewstate.PlaygroundIconButtonViewState

/*
* ViewState for Animal Facts
* */
data class AnimalFactsScreenViewState(
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val fact: String? = null,
    val backButtonViewState: PlaygroundIconButtonViewState,
    val refreshButtonViewState: PlaygroundIconButtonViewState,
)