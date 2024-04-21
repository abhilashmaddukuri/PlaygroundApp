package com.example.playground.home.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.playground.PlaygroundApplication
import com.example.playground.home.screen.HomeScreen
import com.example.playground.home.viewmodel.HomeViewModel
import com.example.playground.shared.viewmodels.ViewModelFactory
import javax.inject.Inject

class HomeFragment: Fragment() {

    @Inject lateinit var viewModelFactory: ViewModelFactory

    private val homeViewModel: HomeViewModel by viewModels { viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as? PlaygroundApplication)?.appComponent?.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext())
            .apply {
                setContent {
                    HomeScreen(homeViewModel.name)
                }
            }
    }
}

