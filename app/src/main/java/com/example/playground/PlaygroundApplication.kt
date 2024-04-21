package com.example.playground

import android.app.Application
import com.example.playground.shared.dagger.DaggerApplicationComponent

class PlaygroundApplication: Application() {
    val appComponent = DaggerApplicationComponent.create()
}