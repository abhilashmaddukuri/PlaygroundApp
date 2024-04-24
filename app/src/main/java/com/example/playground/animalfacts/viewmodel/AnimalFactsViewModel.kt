package com.example.playground.animalfacts.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.playground.animalfacts.viewstate.AnimalFactsScreenViewState
import com.example.playground.dataprovider.AnimalDataProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

class AnimalFactsViewModel @Inject constructor(
    private val animalDataProvider: AnimalDataProvider
) : ViewModel() {

    private val _animalFactsScreenViewStateFlow: MutableStateFlow<AnimalFactsScreenViewState> =
        buildAnimalFactsScreenViewState()
    val animalFactsScreenViewStateFlow: StateFlow<AnimalFactsScreenViewState>
        get() = _animalFactsScreenViewStateFlow


    private fun buildAnimalFactsScreenViewState() = MutableStateFlow(
        AnimalFactsScreenViewState(
            text = "Loading...",
        )
    )

    fun onViewCreated() {
        viewModelScope.launch(Dispatchers.IO) {
            val animalFacts = animalDataProvider.getAnimalFacts()
            _animalFactsScreenViewStateFlow.update {
                it.copy(
                    text = animalFacts.facts.firstOrNull() ?: "No response from internet"
                )
            }
            print(animalFacts)
        }
    }
}