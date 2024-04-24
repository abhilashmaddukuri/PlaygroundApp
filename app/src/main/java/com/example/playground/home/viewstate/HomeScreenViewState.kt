package com.example.playground.home.viewstate

/*
* ViewState for Home Screen
* */
data class HomeScreenViewState(
    val buttonText: String,
    val buttonClick: (() -> Unit)? = null,
)