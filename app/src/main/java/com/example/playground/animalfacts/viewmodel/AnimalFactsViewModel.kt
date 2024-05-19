package com.example.playground.animalfacts.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.playground.R
import com.example.playground.animalfacts.viewstate.AnimalFactsScreenViewState
import com.example.playground.dataprovider.AnimalDataProvider
import com.example.playground.shared.view.viewstate.PlaygroundIconButtonViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class AnimalFactsViewModel @Inject constructor(
    private val application: Application,
    private val animalDataProvider: AnimalDataProvider
) : ViewModel() {

    companion object {
        private const val DELAY_STOP_TIMEOUT_IN_MILLIS = 5000L
    }

    private val _animalFactsScreenViewStateFlow: MutableStateFlow<AnimalFactsScreenViewState> =
        buildAnimalFactsScreenViewState()
    val animalFactsScreenViewStateFlow: StateFlow<AnimalFactsScreenViewState>
        get() = _animalFactsScreenViewStateFlow.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(DELAY_STOP_TIMEOUT_IN_MILLIS),
            initialValue = _animalFactsScreenViewStateFlow.value,
        )

    private val _navigateUpFlow: MutableSharedFlow<Unit> = MutableSharedFlow()
    val navigateUp: SharedFlow<Unit>
        get() = _navigateUpFlow

    fun onViewCreated() {
        fetchNewFact()
    }

    private fun buildAnimalFactsScreenViewState() = MutableStateFlow(
        AnimalFactsScreenViewState(
            isLoading = true,
            backButtonViewState = PlaygroundIconButtonViewState(
                icon = R.drawable.ic_back,
                contentDescription = application.getString(R.string.animal_facts_back_button_content_desc),
                onClick = {
                    viewModelScope.launch {
                        _navigateUpFlow.emit(Unit)
                    }
                }
            ),
            refreshButtonViewState = PlaygroundIconButtonViewState(
                icon = R.drawable.ic_refresh,
                contentDescription = application.getString(R.string.animal_facts_refresh_icon_content_desc),
                isEnabled = false,
                onClick = {
                    fetchNewFact()
                }
            )
        )
    )

    private fun fetchNewFact() {
        viewModelScope.launch(Dispatchers.IO) {
            showLoading()
            val animalFacts = animalDataProvider.getAnimalFacts()
            _animalFactsScreenViewStateFlow.update {
                it.copy(
                    isLoading = false,
                    refreshButtonViewState = it.refreshButtonViewState.copy(isEnabled = true),
                    isError = animalFacts.success.not(),
                    fact = animalFacts.facts.firstOrNull(),
                )
            }
        }
    }

    private fun showLoading() {
        viewModelScope.launch {
            _animalFactsScreenViewStateFlow.update {
                it.copy(
                    isLoading = true,
                    refreshButtonViewState = it.refreshButtonViewState.copy(isEnabled = false),
                )
            }
        }
    }
}