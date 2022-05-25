package com.vinicius.pokeapp.pokemondetail.presentation.model

data class PokemonEvolutionChainUiModel(
    val idBasePokemon: Int,
    val nameBasePokemon: String,
    val levelToEvolve: Int?,
    val nameEvolvedPokemon: String,
    val basePokemonImageUrl: String = "",
    val evolvedPokemonImageUrl: String = ""
)