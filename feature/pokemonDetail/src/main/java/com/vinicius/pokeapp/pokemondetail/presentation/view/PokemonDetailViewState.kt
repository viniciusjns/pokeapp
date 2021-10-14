package com.vinicius.pokeapp.pokemondetail.presentation.view

import androidx.lifecycle.MutableLiveData
import com.vinicius.pokeapp.pokemondetail.presentation.model.PokemonDetailUiModel

class PokemonDetailViewState {

    val action = MutableLiveData<Action>()
    val state = MutableLiveData<State>()
    val pokemonLiveData = MutableLiveData<PokemonDetailUiModel>(null)

    enum class State {
        LOADING, SUCCESS, ERROR
    }

    sealed class Action {
        object SetupDetailedPokemon : Action()
    }
}