package com.vinicius.pokeapp.pokemonlist.presentation

import androidx.lifecycle.viewModelScope
import com.vinicius.pokeapp.core.views.BaseViewModel
import com.vinicius.pokeapp.pokemonlist.domain.PokemonListUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class PokemonListViewModel @Inject constructor(
    private val pokemonListUseCase: PokemonListUseCase
) : BaseViewModel<PokemonListViewState, PokemonListViewAction>() {

    override val viewState = PokemonListViewState()

    override fun dispatchViewAction(viewAction: PokemonListViewAction) {
        when (viewAction) {
            is PokemonListViewAction.FetchPokemonHeroku -> {
                fetchPokemonHeroku()
            }
        }
    }

    private fun fetchPokemonHeroku() {
        viewModelScope.launch {
            viewState.state.value = PokemonListViewState.State.LOADING
            pokemonListUseCase.fetchPokemons().onSuccess {
                viewState.state.value = PokemonListViewState.State.SUCCESS
                viewState.pokemonLiveData.value = it
            }.onError {
                viewState.state.value = PokemonListViewState.State.ERROR
            }
            viewState.action.value = PokemonListViewState.Action.SetupPokemonList
        }
    }
}