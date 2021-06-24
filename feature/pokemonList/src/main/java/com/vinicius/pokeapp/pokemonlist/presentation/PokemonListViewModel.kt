package com.vinicius.pokeapp.pokemonlist.presentation

import androidx.lifecycle.viewModelScope
import com.vinicius.pokeapp.core.views.BaseViewModel
import com.vinicius.pokeapp.pokemonlist.domain.PokemonDomainModel
import com.vinicius.pokeapp.pokemonlist.domain.PokemonListUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class PokemonListViewModel @Inject constructor(
    private val pokemonListUseCase: PokemonListUseCase
) : BaseViewModel<PokemonListViewState, PokemonListViewAction>() {

    override val viewState = PokemonListViewState()

    init {
        fetchPokemons()
    }

    override fun dispatchViewAction(viewAction: PokemonListViewAction) {
        when (viewAction) {
            is PokemonListViewAction.FetchPokemonHeroku -> {
                fetchPokemons()
            }
        }
    }

    private fun fetchPokemons() {
        viewModelScope.launch {
            viewState.state.value = PokemonListViewState.State.LOADING
            pokemonListUseCase.fetchPokemons().onSuccess {
                if (it.isEmpty())
                    viewState.state.value = PokemonListViewState.State.EMPTY
                else
                    viewState.state.value = PokemonListViewState.State.SUCCESS
                viewState.pokemonLiveData.value = it.map {
                    PokemonListUiModel(
                        id = it.id,
                        name = it.name,
                        types = it.types,
                        imageUrl = it.imageUrl,
                        description = it.description,
                        species = it.species,
                        height = it.height,
                        weight = it.weight,
                        evYield = it.evYield,
                        catchRate = it.catchRate,
                        baseFriendship = it.baseFriendship,
                        baseExp = it.baseExp,
                        growthRate = it.growthRate,
                    )
                }
                viewState.action.value = PokemonListViewState.Action.SetupPokemonList
            }.onError {
                viewState.state.value = PokemonListViewState.State.ERROR
                viewState.pokemonLiveData.value = emptyList()
            }
        }
    }
}