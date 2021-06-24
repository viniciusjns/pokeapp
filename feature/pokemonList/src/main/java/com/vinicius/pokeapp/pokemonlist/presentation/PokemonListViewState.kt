package com.vinicius.pokeapp.pokemonlist.presentation

import androidx.lifecycle.MutableLiveData

class PokemonListViewState {

    val action = MutableLiveData<Action>()
    val state = MutableLiveData<State>()
    val pokemonLiveData = MutableLiveData<List<PokemonListUiModel>>(null)
//    val pokemonLiveData = _pokemonLiveData as LiveData<List<Pokemon>>

    enum class State {
        LOADING, SUCCESS, ERROR, EMPTY
    }

    sealed class Action {
        object SetupPokemonList : Action()
    }
}