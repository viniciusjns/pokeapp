package com.vinicius.pokeapp.pokemonlist.presentation

import androidx.lifecycle.MutableLiveData
import com.vinicius.pokeapp.service.response.Pokemon

class PokemonListViewState {

    val action = MutableLiveData<Action>()
    val state = MutableLiveData<State>()
    val pokemonLiveData = MutableLiveData<List<Pokemon>>(null)

    enum class State {
        LOADING, SUCCESS, ERROR, EMPTY
    }

    sealed class Action {
        object SetupPokemonList : Action()
    }
}