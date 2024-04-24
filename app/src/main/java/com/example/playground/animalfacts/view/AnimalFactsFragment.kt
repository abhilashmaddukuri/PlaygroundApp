package com.example.playground.animalfacts.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.playground.PlaygroundApplication
import com.example.playground.animalfacts.screen.AnimalFactsScreen
import com.example.playground.animalfacts.viewmodel.AnimalFactsViewModel
import com.example.playground.shared.ui.theme.PlaygroundTheme
import com.example.playground.shared.viewmodels.ViewModelFactory
import javax.inject.Inject

class AnimalFactsFragment: Fragment() {

    @Inject lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: AnimalFactsViewModel by viewModels { viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as? PlaygroundApplication)?.getPlaygroundAppComponent()?.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext())
            .apply {
                setContent {
                    PlaygroundTheme {
                        val viewState by viewModel.animalFactsScreenViewStateFlow.collectAsState()
                        AnimalFactsScreen(viewState)
                    }
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onViewCreated()
    }
}

