package com.example.playground.shared.view.viewstate

import androidx.annotation.DrawableRes

data class PlaygroundIconButtonViewState(
    @DrawableRes val icon: Int,
    val contentDescription: String = "",
    val isEnabled: Boolean = true,
    val onClick: () -> Unit,
)