package com.vinicius.pokeapp.pokemondetail.presentation.model

import android.os.Parcelable
import com.vinicius.pokeapp.core.model.BasePokemonUiModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonDetailUiModel(
    override val id: String,
    override val name: String,
    override val types: List<String>?,
    override val imageUrl: String?,
    val pokemonAboutUiModel: PokemonAboutUiModel,
    val pokemonStatsUiModel: PokemonStatsUiModel,
    val pokemonEvolutionUiModel: PokemonEvolutionUiModel
) : BasePokemonUiModel(id, name, types, imageUrl), Parcelable
