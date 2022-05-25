package com.vinicius.pokeapp.pokemondetail.domain.model

data class PokemonEvolutionDomainModel(
    val idBasePokemon: Int?,
    val levelToEvolve: Int,
    val idEvolvedPokemon: Int?
)