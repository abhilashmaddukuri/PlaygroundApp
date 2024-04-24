package com.example.playground.repository.animal.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AnimalFactsResponse(
    val facts: List<String>,
    val success: Boolean
): Parcelable
