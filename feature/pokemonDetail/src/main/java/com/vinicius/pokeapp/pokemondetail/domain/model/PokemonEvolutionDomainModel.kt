package com.vinicius.pokeapp.pokemondetail.domain.model

data class PokemonEvolutionDomainModel(
    val idBasePokemon: Int,
    val nameBasePokemon: String,
    val levelToEvolve: Int?,
    val idEvolvedPokemon: Int,
    val nameEvolvedPokemon: String,
    val basePokemonImageUrl: String = "",
    val evolvedPokemonImageUrl: String = ""
)