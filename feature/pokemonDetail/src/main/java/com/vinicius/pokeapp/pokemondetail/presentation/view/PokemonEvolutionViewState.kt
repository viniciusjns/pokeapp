package com.vinicius.pokeapp.pokemondetail.presentation.view

import androidx.lifecycle.MutableLiveData
import com.vinicius.pokeapp.pokemondetail.presentation.model.PokemonSpecieUiModel

class PokemonEvolutionViewState {

    val action = MutableLiveData<Action>()
    val state = MutableLiveData<State>()
    val pokemonLiveData = MutableLiveData<PokemonSpecieUiModel>(null)

    enum class State {
        LOADING, SUCCESS, ERROR
    }

    sealed class Action {
    }
}