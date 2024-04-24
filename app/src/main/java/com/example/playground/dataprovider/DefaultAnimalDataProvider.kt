package com.example.playground.dataprovider

import com.example.playground.repository.animal.AnimalAPIService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultAnimalDataProvider @Inject constructor(
    private val animalAPIService: AnimalAPIService
): AnimalDataProvider {
    override suspend fun getAnimalFacts() =
        animalAPIService.getFacts()
}