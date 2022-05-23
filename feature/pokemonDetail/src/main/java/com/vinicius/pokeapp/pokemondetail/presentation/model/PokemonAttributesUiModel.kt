package com.vinicius.pokeapp.pokemondetail.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonAttributesUiModel(
    val attributeName: String,
    val currentValue: Int,
    val minValue: Int,
    val maxValue: Int
) : Parcelable