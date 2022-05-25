package com.vinicius.pokeapp.pokemondetail.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonEvolutionUiModel(
    val id: Int,
    val baseColor: Int
) : Parcelable