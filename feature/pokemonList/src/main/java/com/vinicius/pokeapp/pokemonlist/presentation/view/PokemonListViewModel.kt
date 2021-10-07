package com.vinicius.pokeapp.pokemonlist.presentation.view

import androidx.lifecycle.viewModelScope
import com.vinicius.pokeapp.core.views.BaseViewModel
import com.vinicius.pokeapp.pokemonlist.domain.model.PokemonListDomainErrorModel
import com.vinicius.pokeapp.pokemonlist.domain.useCase.GetPokemonsUseCase
import com.vinicius.pokeapp.pokemonlist.presentation.mapper.PokemonListPresentationMapper
import kotlinx.coroutines.launch
import javax.inject.Inject

class PokemonListViewModel @Inject constructor(
    private val getPokemonsUseCase: GetPokemonsUseCase,
    private val pokemonListPresentationMapper: PokemonListPresentationMapper
) : BaseViewModel<PokemonListViewState, PokemonListViewAction>() {

    override val viewState = PokemonListViewState()

    override fun dispatchViewAction(viewAction: PokemonListViewAction) {
        when (viewAction) {
            is PokemonListViewAction.GetPokemons -> {
                getPokemons()
            }
        }
    }

    private fun getPokemons() {
        viewModelScope.launch {
            viewState.state.value = PokemonListViewState.State.LOADING
            getPokemonsUseCase().mapSuccess {
                viewState.pokemonLiveData.value = it.map { pokemonListDomainModel ->
                    pokemonListPresentationMapper.mapFrom(pokemonListDomainModel)
                }
            }.onSuccess {
                viewState.state.value = PokemonListViewState.State.SUCCESS
                viewState.action.value = PokemonListViewState.Action.SetupPokemonList
            }.onError {
                when (it) {
                    PokemonListDomainErrorModel.GenericError,
                    PokemonListDomainErrorModel.NetworkError -> {
                        viewState.state.value = PokemonListViewState.State.ERROR
                        viewState.pokemonLiveData.value = emptyList()
                    }
                }
            }
        }
    }
}