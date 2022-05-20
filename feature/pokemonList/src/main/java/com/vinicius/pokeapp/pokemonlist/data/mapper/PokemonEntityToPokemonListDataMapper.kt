package com.vinicius.pokeapp.pokemonlist.data.mapper

import com.vinicius.pokeapp.database.entity.PokemonEntity
import com.vinicius.pokeapp.pokemonlist.data.model.PokemonListDataModel

fun PokemonEntity.toPokemonListDataModel() = PokemonListDataModel(
    id = id.toString(),
    name = name,
    types = types,
    imageUrl = imageUrl
)