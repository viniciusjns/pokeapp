package com.vinicius.pokeapp.pokemondetail.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonAttributesUiModel(
    val attributeName: String,
    val currentValue: String,
    val minValue: String,
    val maxValue: String
) : Parcelable