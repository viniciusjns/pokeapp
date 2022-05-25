package com.vinicius.pokeapp.pokemondetail.data.mapper

import com.vinicius.pokeapp.pokemondetail.data.model.PokemonSpecieResponse
import com.vinicius.pokeapp.pokemondetail.domain.model.PokemonSpecieDomainModel

fun PokemonSpecieResponse.toPokemonSpecieDomainModel() = PokemonSpecieDomainModel(
    evolutionChainId = evolutionChainId
)