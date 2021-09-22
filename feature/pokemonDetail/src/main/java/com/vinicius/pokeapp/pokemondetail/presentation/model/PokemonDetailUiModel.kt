package com.vinicius.pokeapp.pokemondetail.presentation.model

import androidx.core.graphics.toColorInt
import com.vinicius.pokeapp.core.ui.Colors

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

    fun getTypeColor(): Int = types?.let {
        Colors.valueOf(it[0].toUpperCase()).type.toColorInt()
    } ?: "#000000".toColorInt()
}
