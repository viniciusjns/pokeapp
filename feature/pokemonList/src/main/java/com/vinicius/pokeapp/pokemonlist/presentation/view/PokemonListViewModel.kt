package com.vinicius.pokeapp.pokemonlist.presentation.view

import androidx.lifecycle.viewModelScope
import com.vinicius.pokeapp.core.views.BaseViewModel
import com.vinicius.pokeapp.pokemonlist.domain.useCase.PokemonListUseCase
import com.vinicius.pokeapp.pokemonlist.presentation.mapper.PokemonListPresentationMapper
import com.vinicius.pokeapp.service.response.ResultWrapper
import kotlinx.coroutines.launch
import javax.inject.Inject

class PokemonListViewModel @Inject constructor(
    private val pokemonListUseCase: PokemonListUseCase,
    private val pokemonListPresentationMapper: PokemonListPresentationMapper
) : BaseViewModel<PokemonListViewState, PokemonListViewAction>() {

    override val viewState = PokemonListViewState()

    override fun dispatchViewAction(viewAction: PokemonListViewAction) {
        when (viewAction) {
            is PokemonListViewAction.FetchPokemons -> {
                getPokemons()
            }
        }
    }

    private fun getPokemons() {
        viewModelScope.launch {
            viewState.state.value = PokemonListViewState.State.LOADING
            when (val result = pokemonListUseCase.getPokemons()) {
                is ResultWrapper.Success -> {
                    viewState.pokemonLiveData.value = result.value.map { pokemonListDomainModel ->
                        pokemonListPresentationMapper.mapFrom(pokemonListDomainModel)
                    }
                    viewState.state.value = PokemonListViewState.State.SUCCESS
                    viewState.action.value = PokemonListViewState.Action.SetupPokemonList
                }
                is ResultWrapper.Error.GenericError,
                is ResultWrapper.Error.NetworkError -> {
                    viewState.state.value = PokemonListViewState.State.ERROR
                    viewState.pokemonLiveData.value = emptyList()
                }
            }
        }
    }
}