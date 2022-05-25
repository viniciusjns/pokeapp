package com.vinicius.pokeapp.pokemondetail.presentation.mapper

import com.vinicius.pokeapp.pokemondetail.domain.model.PokemonEvolutionDomainModel
import com.vinicius.pokeapp.pokemondetail.presentation.model.PokemonEvolutionChainUiModel

fun PokemonEvolutionDomainModel.toPokemonEvolutionUiModel() = PokemonEvolutionChainUiModel(
    idBasePokemon = idBasePokemon,
    nameBasePokemon = nameBasePokemon,
    levelToEvolve = levelToEvolve,
    nameEvolvedPokemon = nameEvolvedPokemon,
    basePokemonImageUrl = basePokemonImageUrl,
    evolvedPokemonImageUrl = evolvedPokemonImageUrl
)