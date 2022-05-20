package com.vinicius.pokeapp.pokemonlist.domain.mapper

import com.vinicius.pokeapp.pokemonlist.data.model.PokemonListDataModel
import com.vinicius.pokeapp.pokemonlist.domain.model.PokemonListDomainModel

fun PokemonListDataModel.toPokemonListDomainModel(): PokemonListDomainModel = PokemonListDomainModel(
    id = id,
    name = name,
    types = types,
    imageUrl = imageUrl,
)