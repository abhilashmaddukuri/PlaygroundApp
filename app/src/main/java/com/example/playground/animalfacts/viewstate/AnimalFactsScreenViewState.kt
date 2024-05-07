package com.example.playground.animalfacts.viewstate

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.ui.graphics.vector.ImageVector

/*
* ViewState for Animal Facts
* */
data class AnimalFactsScreenViewState(
    val text: String,
    val backButtonViewState: BackButtonViewState,
)

data class BackButtonViewState(
    val icon: ImageVector = Icons.AutoMirrored.Filled.ArrowBack,
    val contentDescription: String = "",
    val onClick: () -> Unit
)