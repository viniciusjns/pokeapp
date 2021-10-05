package com.vinicius.pokeapp.pokemonlist.presentation.view

import androidx.lifecycle.viewModelScope
import com.vinicius.pokeapp.core.views.BaseViewModel
import com.vinicius.pokeapp.pokemonlist.domain.useCase.PokemonListUseCase
import com.vinicius.pokeapp.pokemonlist.presentation.mapper.PokemonListPresentationMapper
import kotlinx.coroutines.launch
import javax.inject.Inject

class PokemonListViewModel @Inject constructor(
    private val pokemonListUseCase: PokemonListUseCase,
    private val pokemonListPresentationMapper: PokemonListPresentationMapper
) : BaseViewModel<PokemonListViewState, PokemonListViewAction>() {

    override val viewState = PokemonListViewState()

    init {
        fetchPokemons()
    }

    override fun dispatchViewAction(viewAction: PokemonListViewAction) {
        when (viewAction) {
            is PokemonListViewAction.FetchPokemons -> {
                fetchPokemons()
            }
        }
    }

    private fun fetchPokemons() {
        viewModelScope.launch {
            viewState.state.value = PokemonListViewState.State.LOADING
            pokemonListUseCase.fetchPokemons().onSuccess {
                viewState.pokemonLiveData.value = it.map { pokemonListDomainModel ->
                    pokemonListPresentationMapper.mapFrom(pokemonListDomainModel)
                }
                if (it.isEmpty())
                    viewState.state.value = PokemonListViewState.State.EMPTY
                else
                    viewState.state.value = PokemonListViewState.State.SUCCESS
                viewState.action.value = PokemonListViewState.Action.SetupPokemonList
            }.onError {
                viewState.state.value = PokemonListViewState.State.ERROR
                viewState.pokemonLiveData.value = emptyList()
            }
        }
    }
}