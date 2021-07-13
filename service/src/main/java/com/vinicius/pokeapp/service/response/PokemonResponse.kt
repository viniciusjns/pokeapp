package com.vinicius.pokeapp.service.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonResponse(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "types") val types: List<String>?,
    @field:Json(name = "image") val imageUrl: String?,
    @field:Json(name = "description") val description: String?,
    @field:Json(name = "species") val species: String?,
    @field:Json(name = "height") val height: Double?,
    @field:Json(name = "weight") val weight: Double?,
    @field:Json(name = "training") val training: Training?,
    @field:Json(name = "breedings") val breedings: Breedings?,
    @field:Json(name = "baseStats") val baseStats: BaseStats?,
)

@JsonClass(generateAdapter = true)
data class Training(
    @field:Json(name = "evYield") val evYield: String?,
    @field:Json(name = "catchRate") val catchRate: DefaultData?,
    @field:Json(name = "baseFriendship") val baseFriendship: DefaultData?,
    @field:Json(name = "baseExp") val baseExp: Int?,
    @field:Json(name = "growthRate") val growthRate: String?,
)

@JsonClass(generateAdapter = true)
data class DefaultData(
    @field:Json(name = "value") val value: Int?,
    @field:Json(name = "text") val text: String?,
)

@JsonClass(generateAdapter = true)
data class Breedings(
    @field:Json(name = "eggGroups") val eggGroups: List<String>?,
    @field:Json(name = "gender") val gender: Gender?,
    @field:Json(name = "eggCycles") val eggCycles: DefaultData?,
)

@JsonClass(generateAdapter = true)
data class Gender(
    @field:Json(name = "male") val male: Double?,
    @field:Json(name = "female") val female: Double?,
)

@JsonClass(generateAdapter = true)
data class BaseStats(
    @field:Json(name = "hp") val hp: List<Int>?,
    @field:Json(name = "attack") val attack: List<Int>?,
    @field:Json(name = "defence") val defense: List<Int>?,
    @field:Json(name = "specialAttack") val specialAttack: List<Int>?,
    @field:Json(name = "specialDefence") val specialDefense: List<Int>?,
    @field:Json(name = "speed") val speed: List<Int>?,
)