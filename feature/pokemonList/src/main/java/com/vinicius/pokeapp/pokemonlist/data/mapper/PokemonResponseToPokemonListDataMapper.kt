package com.vinicius.pokeapp.pokemonlist.data.mapper

import com.vinicius.pokeapp.pokemonlist.data.model.PokemonListDataModel
import com.vinicius.pokeapp.pokemonlist.data.model.PokemonResponse

fun PokemonResponse.toPokemonListDataModel() = PokemonListDataModel(
    id = id.toString(),
    name = name,
    types = types,
    imageUrl = imageUrl,
)