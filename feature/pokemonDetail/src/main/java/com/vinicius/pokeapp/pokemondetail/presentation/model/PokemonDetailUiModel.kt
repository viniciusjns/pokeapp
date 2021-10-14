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

    val baseColor: Int?
        get() = types?.let {
            Colors.valueOf(it[0].uppercase()).background.toColorInt()
        }

    fun getNumber(): String {
        val number = id.padStart(3, '0')
        return "#${number}"
    }
}
