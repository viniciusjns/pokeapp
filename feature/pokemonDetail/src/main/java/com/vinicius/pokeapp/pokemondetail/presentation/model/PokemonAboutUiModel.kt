package com.vinicius.pokeapp.pokemondetail.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonAboutUiModel(
    val description: String?,
    val species: String?,
    val height: Double?,
    val weight: Double?,
    val evYield: String?,
    val catchRate: DefaultDataUiModel?,
    val baseFriendship: DefaultDataUiModel?,
    val baseExp: Int?,
    val growthRate: String?,
    val male: Double?,
    val female: Double?,
    val eggGroups: String?,
    val eggCycles: DefaultDataUiModel?,
    val baseColor: Int
) : Parcelable

@Parcelize
data class DefaultDataUiModel(
    val value: Int?,
    val text: String?
): Parcelable