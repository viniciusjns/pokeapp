package com.vinicius.pokeapp.pokemonlist.data.mapper

import com.vinicius.pokeapp.database.entity.PokemonEntity
import com.vinicius.pokeapp.pokemonlist.domain.model.PokemonListDomainModel

fun PokemonEntity.toPokemonListDomainModel() = PokemonListDomainModel(
    id = id.toString(),
    name = name,
    types = types,
    imageUrl = imageUrl
)