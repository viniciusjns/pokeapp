package com.vinicius.pokeapp.pokemonlist.domain

data class PokemonDomainModel(
    val id: String,
    val name: String,
    val types: List<String>?,
    val imageUrl: String?,
    val description: String?,
    val species: String?,
    val height: String?,
    val weight: String?,
    val evYield: String?,
    val catchRate: String?,
    val baseFriendship: String?,
    val baseExp: String?,
    val growthRate: String?,
)