package com.example.playground.shared.dagger

import android.app.Application
import android.content.Context
import com.example.playground.animalfacts.view.AnimalFactsFragment
import com.example.playground.home.view.HomeFragment
import com.example.playground.shared.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

/*
* Dagger Application Component
* */
@Singleton
@Component(modules = [PlaygroundViewModelModule::class, PlaygroundAppModule::class])
interface ApplicationComponent {
    fun getContext(): Context
    fun getApplication(): Application
    fun inject(mainActivity: MainActivity)
    fun inject(homeFragment: HomeFragment)
    fun inject(animalFactsFragment: AnimalFactsFragment)
}