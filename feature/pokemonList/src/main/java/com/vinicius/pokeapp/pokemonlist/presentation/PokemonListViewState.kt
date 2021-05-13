package com.vinicius.pokeapp.pokemonlist.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.vinicius.pokeapp.service.response.Pokemon

class PokemonListViewState {

    val action = MutableLiveData<Action>()
    val state = MutableLiveData<State>()
    val pokemonLiveData = MutableLiveData<List<Pokemon>>()

    enum class State {
        LOADING, SUCCESS, ERROR
    }

    sealed class Action {
        object SetupPokemonList : Action()
    }
}