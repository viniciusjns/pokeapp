package com.vinicius.pokeapp.core.views

import androidx.lifecycle.ViewModel

abstract class BaseViewModel<State, Action>(
    initialState: State
) : ViewModel() {
    val viewState: State = initialState
    abstract fun dispatchViewAction(viewAction: Action)
}