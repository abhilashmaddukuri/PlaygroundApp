package com.example.playground.dataprovider

import com.example.playground.repository.animal.model.AnimalFactsResponse

interface AnimalDataProvider {
    suspend fun getAnimalFacts(): AnimalFactsResponse
}