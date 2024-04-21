package com.example.playground.shared.dagger

import androidx.lifecycle.ViewModel
import com.example.playground.home.viewmodel.HomeViewModel
import com.example.playground.shared.viewmodels.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/*
* Playground module for providing viewmodels
* */
@Module
abstract class PlaygroundViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun getHomeViewModel(
        viewModel: HomeViewModel
    ): ViewModel

}