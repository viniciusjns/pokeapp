package com.vinicius.pokeapp.pokemondetail.presentation.model

import com.vinicius.pokeapp.core.model.BasePokemonUiModel

data class PokemonDetailUiModel(
    override val id: String,
    override val name: String,
    override val types: List<String>?,
    override val imageUrl: String?,
    val pokemonAboutModel: PokemonAboutModel,
    val pokemonStatsModel: PokemonStatsModel,
    val pokemonEvolutionModel: PokemonEvolutionModel,
) : BasePokemonUiModel(id, name, types, imageUrl)
