package com.example.playground

import android.app.Application
import com.example.playground.dataprovider.AnimalDataProvider
import com.example.playground.dataprovider.DefaultAnimalDataProvider
import com.example.playground.repository.RetrofitClient
import com.example.playground.repository.animal.AnimalAPIService
import com.example.playground.shared.dagger.ApplicationComponent
import com.example.playground.shared.dagger.DaggerApplicationComponent
import com.example.playground.shared.dagger.PlaygroundAppModule

class PlaygroundApplication: Application() {
    private lateinit var appComponent: ApplicationComponent
    private lateinit var animalDataProvider: AnimalDataProvider

    override fun onCreate() {
        super.onCreate()

        val animalAPIService = RetrofitClient.getRetrofit().create(AnimalAPIService::class.java)
        animalDataProvider = DefaultAnimalDataProvider(animalAPIService)

        val playgroundAppModule = PlaygroundAppModule(
            animalDataProvider
        )

        appComponent = DaggerApplicationComponent
            .builder()
            .playgroundAppModule(playgroundAppModule)
            .build()
    }

    fun getPlaygroundAppComponent() = appComponent
}