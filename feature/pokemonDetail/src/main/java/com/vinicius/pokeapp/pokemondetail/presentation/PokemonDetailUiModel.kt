package com.vinicius.pokeapp.pokemondetail.presentation

import com.vinicius.pokeapp.pokemondetail.presentation.model.PokemonAboutModel
import com.vinicius.pokeapp.pokemondetail.presentation.model.PokemonEvolutionModel
import com.vinicius.pokeapp.pokemondetail.presentation.model.PokemonStatsModel

data class PokemonDetailUiModel(
    val id: String,
    val name: String,
    val types: List<String>?,
    val imageUrl: String?,
    val pokemonAboutModel: PokemonAboutModel,
    val pokemonStatsModel: PokemonStatsModel,
    val pokemonEvolutionModel: PokemonEvolutionModel,
) {

    fun getNumber(): String {
        val number = id.padStart(3, '0')
        return "#${number}"
    }
}
