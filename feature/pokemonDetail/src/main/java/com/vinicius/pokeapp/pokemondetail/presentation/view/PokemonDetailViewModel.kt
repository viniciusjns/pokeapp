package com.vinicius.pokeapp.pokemondetail.presentation.view

import androidx.lifecycle.viewModelScope
import com.vinicius.pokeapp.core.views.BaseViewModel
import com.vinicius.pokeapp.pokemondetail.domain.useCase.PokemonDetailUseCase
import com.vinicius.pokeapp.pokemondetail.presentation.mapper.PokemonDetailPresentationMapper
import kotlinx.coroutines.launch
import javax.inject.Inject

class PokemonDetailViewModel @Inject constructor(
    private val pokemonDetailUseCase: PokemonDetailUseCase,
    private val pokemonDetailPresentationMapper: PokemonDetailPresentationMapper,
) : BaseViewModel<PokemonDetailViewState, PokemonDetailViewAction>() {

    override val viewState = PokemonDetailViewState()

    override fun dispatchViewAction(viewAction: PokemonDetailViewAction) {
        when(viewAction) {
            is PokemonDetailViewAction.GetPokemonById -> getPokemonById(viewAction.pokemonId)
        }
    }

    private fun getPokemonById(id: Int) {
        viewModelScope.launch {
            pokemonDetailUseCase.getPokemonById(id).onSuccess {
                val pokemonUiModel = pokemonDetailPresentationMapper.mapFrom(it)
                viewState.pokemonLiveData.value = pokemonUiModel
            }.onError {
                viewState.pokemonLiveData.value = null
            }
        }
    }


}