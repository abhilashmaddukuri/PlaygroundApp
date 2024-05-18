package com.example.playground.home.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.playground.R
import com.example.playground.home.viewstate.HomeScreenViewState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

/*
* ViewModel for Home Screen
* */
class HomeViewModel @Inject constructor(
    private val application: Application,
) : ViewModel() {

    companion object {
        private const val DELAY_STOP_TIMEOUT_IN_MILLIS = 5000L
    }

    private val _homeScreenViewStateFlow: MutableStateFlow<HomeScreenViewState> =
        buildHomeScreenViewState()
    val homeScreenViewStateFlow: StateFlow<HomeScreenViewState>
        get() = _homeScreenViewStateFlow.stateIn(
            scope = viewModelScope,
            started = WhileSubscribed(DELAY_STOP_TIMEOUT_IN_MILLIS),
            initialValue = _homeScreenViewStateFlow.value,
        )

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