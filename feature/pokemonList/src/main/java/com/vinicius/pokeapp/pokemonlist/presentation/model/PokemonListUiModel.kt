package com.vinicius.pokeapp.pokemonlist.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonListUiModel(
    val id: String,
    val name: String,
    val types: List<String>?,
    val imageUrl: String?,
) : Parcelable {

    fun getNumber(): String {
        val number = id.padStart(3, '0')
        return "#${number}"
    }
}
