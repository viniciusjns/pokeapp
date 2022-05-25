package com.vinicius.pokeapp.pokemondetail.presentation.view

import androidx.lifecycle.MutableLiveData
import com.vinicius.pokeapp.pokemondetail.presentation.model.PokemonEvolutionChainUiModel

class PokemonEvolutionViewState {

    val action = MutableLiveData<Action>()
    val state = MutableLiveData<State>()
    val pokemonLiveData = MutableLiveData<List<PokemonEvolutionChainUiModel>>(null)

    enum class State {
        LOADING, SUCCESS, ERROR
    }

    sealed class Action {
    }
}