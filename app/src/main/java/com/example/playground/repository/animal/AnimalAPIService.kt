package com.example.playground.repository.animal

import com.example.playground.repository.animal.model.AnimalFactsResponse
import retrofit2.http.GET

interface AnimalAPIService {
    @GET("/api/facts")
    suspend fun getFacts(): AnimalFactsResponse
}