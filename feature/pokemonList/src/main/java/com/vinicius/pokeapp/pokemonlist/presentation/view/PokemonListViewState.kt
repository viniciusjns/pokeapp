package com.vinicius.pokeapp.pokemonlist.presentation.view

import androidx.lifecycle.MutableLiveData
import com.vinicius.pokeapp.pokemonlist.presentation.model.PokemonListUiModel

class PokemonListViewState {

    val action = MutableLiveData<Action>()
    val state = MutableLiveData<State>()
    val pokemonLiveData = MutableLiveData<List<PokemonListUiModel>>(null)

    enum class State {
        LOADING, SUCCESS, ERROR, EMPTY
    }

    sealed class Action {
        object SetupPokemonList : Action()
    }
}