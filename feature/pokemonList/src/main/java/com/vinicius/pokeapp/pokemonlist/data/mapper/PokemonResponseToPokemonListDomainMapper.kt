package com.vinicius.pokeapp.pokemonlist.data.mapper

import com.vinicius.pokeapp.pokemonlist.data.model.PokemonResponse
import com.vinicius.pokeapp.pokemonlist.domain.model.PokemonListDomainModel

fun PokemonResponse.toPokemonListDomainModel() = PokemonListDomainModel(
    id = id.toString(),
    name = name,
    types = types,
    imageUrl = imageUrl,
)