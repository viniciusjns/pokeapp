package com.vinicius.pokeapp.pokemondetail.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class PokemonStatsModel(
    val hp: List<Int>?,
    val attack: List<Int>?,
    val defense: List<Int>?,
    val specialAttack: List<Int>?,
    val specialDefense: List<Int>?,
    val spped: List<Int>?,
) : Parcelable