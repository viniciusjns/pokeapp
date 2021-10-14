package com.vinicius.pokeapp.pokemondetail.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonAboutModel(
    val description: String?,
    val species: String?,
    val height: String?,
    val weight: String?,
    val evYield: String?,
    val catchRate: String?,
    val baseFriendship: String?,
    val baseExp: String?,
    val growthRate: String?,
    val gender: String?,
    val eggGroups: String?,
    val eggCycles: String?,
    val baseColor: Int?
) : Parcelable