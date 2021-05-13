package com.vinicius.pokeapp.core.views

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.SupervisorJob

interface PresentationModel<T, A> {
    val viewState: T
    fun dispatchViewAction(viewAction: A)
}

abstract class BaseViewModel<T, A> : ViewModel(), PresentationModel<T, A>