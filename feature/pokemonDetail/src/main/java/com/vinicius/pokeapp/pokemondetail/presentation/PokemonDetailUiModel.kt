package com.vinicius.pokeapp.pokemondetail.presentation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonDetailUiModel(
    val id: String,
    val name: String,
    val types: List<String>?,
    val imageUrl: String?,
    val description: String?,
    val species: String?,
    val height: String?,
    val weight: String?,
    val evYield: String?,
    val catchRate: String?,
    val baseFriendship: String?,
    val baseExp: String?,
    val growthRate: String?,
) : Parcelable {

    fun getNumber(): String {
        val number = id.padStart(3, '0')
        return "#${number}"
    }
}
