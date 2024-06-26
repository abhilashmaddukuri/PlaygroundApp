package com.example.playground.home.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.playground.R
import com.example.playground.home.viewstate.HomeScreenViewState
import com.example.playground.shared.core.stateWhileSubscribed
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/*
* ViewModel for Home Screen
* */
class HomeViewModel @Inject constructor(
    private val application: Application,
) : ViewModel() {

    private val _homeScreenViewStateFlow: MutableStateFlow<HomeScreenViewState> =
        buildHomeScreenViewState()
    val homeScreenViewStateFlow: StateFlow<HomeScreenViewState>
        get() = _homeScreenViewStateFlow.stateWhileSubscribed(viewModelScope)

    private val _navigateToDestinationFlow: MutableSharedFlow<Int> = MutableSharedFlow()
    val navigateToDestinationFlow: SharedFlow<Int>
        get() = _navigateToDestinationFlow

    private fun buildHomeScreenViewState() = MutableStateFlow(
        HomeScreenViewState(
            buttonText = application.getString(R.string.home_dog_facts),
            buttonClick = {
                viewModelScope.launch {
                    _navigateToDestinationFlow.emit(R.id.action_home_to_animal_facts)
                }
            }
        )
    )
}