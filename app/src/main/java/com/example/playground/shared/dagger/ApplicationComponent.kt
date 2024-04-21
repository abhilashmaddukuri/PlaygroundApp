package com.example.playground.shared.dagger

import com.example.playground.home.view.HomeFragment
import com.example.playground.shared.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

/*
* Dagger Application Component
* */
@Singleton
@Component(modules = [PlaygroundViewModelModule::class])
interface ApplicationComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(homeFragment: HomeFragment)
}