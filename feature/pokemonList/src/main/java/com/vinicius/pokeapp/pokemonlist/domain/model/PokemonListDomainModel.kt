package com.vinicius.pokeapp.pokemonlist.domain.model

data class PokemonListDomainModel(
    val id: String,
    val name: String,
    val types: List<String>?,
    val imageUrl: String?,
)