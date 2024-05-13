package com.example.playground.shared.dagger

import android.app.Application
import android.content.Context
import com.example.playground.dataprovider.AnimalDataProvider
import dagger.Module
import dagger.Provides

@Module
class PlaygroundAppModule(
    private val application: Application,
    private val context: Context,
    private val animalDataProvider: AnimalDataProvider
) {
    @Provides
    fun provideApplication(): Application {
        return application
    }

    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    fun provideAnimalProvider(): AnimalDataProvider {
        return animalDataProvider
    }
}
