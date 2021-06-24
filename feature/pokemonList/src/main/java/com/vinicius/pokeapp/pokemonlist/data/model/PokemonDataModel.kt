package com.vinicius.pokeapp.pokemonlist.data.model

data class PokemonDataModel(
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