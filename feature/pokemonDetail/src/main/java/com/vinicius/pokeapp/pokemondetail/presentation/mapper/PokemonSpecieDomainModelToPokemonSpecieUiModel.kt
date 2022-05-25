package com.vinicius.pokeapp.pokemondetail.presentation.mapper

import com.vinicius.pokeapp.pokemondetail.domain.model.PokemonSpecieDomainModel
import com.vinicius.pokeapp.pokemondetail.presentation.model.PokemonSpecieUiModel

fun PokemonSpecieDomainModel.toPokemonSpecieUiModel() = PokemonSpecieUiModel(
    evolutionChainId = evolutionChainId
)