package com.example.playground.shared.core

import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

private const val DELAY_STOP_TIMEOUT_IN_MILLIS = 5000L

fun <T> MutableStateFlow<T>.stateWhileSubscribed(viewModelScope: CoroutineScope): StateFlow<T> {
    return this.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(DELAY_STOP_TIMEOUT_IN_MILLIS),
        initialValue = this.value
    )
}

fun <T> Fragment.collectLatestWhenStarted(flow: Flow<T>, action: suspend (value: T) -> Unit) =
    viewLifecycleOwner.lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            flow.collectLatest(action)
        }
    }