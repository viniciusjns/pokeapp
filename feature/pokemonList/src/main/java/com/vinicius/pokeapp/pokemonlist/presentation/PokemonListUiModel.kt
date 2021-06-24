package com.vinicius.pokeapp.pokemonlist.presentation

import android.os.Parcelable
import com.vinicius.pokeapp.pokemondetail.presentation.PokemonDetailUiModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonListUiModel(
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

fun PokemonListUiModel.toPokemonDetailModel(): PokemonDetailUiModel {
    return PokemonDetailUiModel(
        id = this.id,
        name = this.name,
        types = this.types,
        imageUrl = this.imageUrl,
        description = this.description,
        species = this.species,
        height = this.height,
        weight = this.weight,
        evYield = this.evYield,
        catchRate = this.catchRate,
        baseFriendship = this.baseFriendship,
        baseExp = this.baseExp,
        growthRate = this.growthRate,
    )
}
