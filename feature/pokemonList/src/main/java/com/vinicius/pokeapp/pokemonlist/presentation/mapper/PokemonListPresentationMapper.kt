package com.vinicius.pokeapp.pokemonlist.presentation.mapper

import com.vinicius.pokeapp.pokemonlist.domain.model.PokemonListDomainModel
import com.vinicius.pokeapp.pokemonlist.presentation.model.PokemonListUiModel

fun PokemonListDomainModel.toPokemonListUiModel(): PokemonListUiModel =
    PokemonListUiModel(
        id = id,
        name = name,
        types = types,
        imageUrl = imageUrl,
    )