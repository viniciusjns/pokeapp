package com.vinicius.pokeapp.pokemonlist.data.model

data class PokemonListDataModel(
    val id: String,
    val name: String,
    val types: List<String>?,
    val imageUrl: String?,
)