package com.example.playground.shared.viewmodels

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

/*
* Custom Annotation used for dagger to bind a viewmodel class to a specific type
* */
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)
