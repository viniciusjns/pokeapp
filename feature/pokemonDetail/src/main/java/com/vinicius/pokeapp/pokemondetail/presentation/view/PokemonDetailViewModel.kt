package com.vinicius.pokeapp.pokemondetail.presentation.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vinicius.pokeapp.pokemondetail.domain.useCase.PokemonDetailUseCase
import com.vinicius.pokeapp.pokemondetail.presentation.mapper.PokemonDetailPresentationMapper
import com.vinicius.pokeapp.pokemondetail.presentation.model.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class PokemonDetailViewModel @Inject constructor(
    private val pokemonDetailUseCase: PokemonDetailUseCase,
    private val pokemonDetailPresentationMapper: PokemonDetailPresentationMapper,
) : ViewModel() {

    val pokemonDetailLiveData = MutableLiveData<PokemonDetailUiModel?>()

    fun getPokemonById(id: Int) {
        viewModelScope.launch {
            pokemonDetailUseCase.getPokemonById(id).onSuccess {
                val pokemonUiModel = pokemonDetailPresentationMapper.mapFrom(it)
                pokemonDetailLiveData.value = pokemonUiModel
            }
        }
    }
}