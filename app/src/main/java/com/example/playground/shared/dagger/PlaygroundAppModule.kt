package com.example.playground.shared.dagger

import com.example.playground.dataprovider.AnimalDataProvider
import dagger.Module
import dagger.Provides

@Module
class PlaygroundAppModule(
    private val animalDataProvider: AnimalDataProvider
) {
    @Provides
    fun provideAnimalProvider(): AnimalDataProvider {
        return animalDataProvider
    }
}
