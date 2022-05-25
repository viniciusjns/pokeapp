package com.vinicius.pokeapp.pokemondetail.presentation.view

import androidx.lifecycle.viewModelScope
import com.vinicius.pokeapp.core.views.BaseViewModel
import com.vinicius.pokeapp.pokemondetail.domain.useCase.GetPokemonEvolutionChainUseCase
import com.vinicius.pokeapp.pokemondetail.domain.useCase.GetPokemonSpecieUseCase
import com.vinicius.pokeapp.pokemondetail.presentation.mapper.toPokemonEvolutionUiModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class PokemonEvolutionViewModel @Inject constructor(
    private val getPokemonSpecieUseCase: GetPokemonSpecieUseCase,
    private val getPokemonEvolutionChainUseCase: GetPokemonEvolutionChainUseCase
) : BaseViewModel<PokemonEvolutionViewState, PokemonEvolutionViewAction>(
    PokemonEvolutionViewState()
) {

    override fun dispatchViewAction(viewAction: PokemonEvolutionViewAction) {
        when(viewAction) {
            is PokemonEvolutionViewAction.GetPokemonSpecie -> getPokemonSpecie(viewAction.pokemonId)
        }
    }

    private fun getPokemonSpecie(pokemonId: Int) {
        viewModelScope.launch {
            getPokemonSpecieUseCase(pokemonId).onSuccess { pokemonSpecieDomainModel ->
                getPokemonEvolutionChainUseCase(pokemonSpecieDomainModel.evolutionChainId).onSuccess { pokemonEvolutionDomain ->
                    viewState.pokemonLiveData.value = pokemonEvolutionDomain.map {
                        it.toPokemonEvolutionUiModel()
                    }
                }.onError {

                }
            }.onError {

            }
        }
    }
}