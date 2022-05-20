package com.vinicius.pokeapp.pokemondetail.presentation.view

import androidx.lifecycle.viewModelScope
import com.vinicius.pokeapp.core.views.BaseViewModel
import com.vinicius.pokeapp.pokemondetail.domain.useCase.GetPokemonByIdUseCase
import com.vinicius.pokeapp.pokemondetail.presentation.mapper.toPokemonDetailUiModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class PokemonDetailViewModel @Inject constructor(
    private val getPokemonByIdUseCase: GetPokemonByIdUseCase,
) : BaseViewModel<PokemonDetailViewState, PokemonDetailViewAction>() {

    override val viewState = PokemonDetailViewState()

    override fun dispatchViewAction(viewAction: PokemonDetailViewAction) {
        when(viewAction) {
            is PokemonDetailViewAction.GetPokemonById -> getPokemonById(viewAction.pokemonId)
        }
    }

    private fun getPokemonById(id: Int) {
        viewModelScope.launch {
            getPokemonByIdUseCase(id).onSuccess {
                viewState.pokemonLiveData.value = it.toPokemonDetailUiModel()
            }.onError {
                viewState.pokemonLiveData.value = null
            }
        }
    }
}