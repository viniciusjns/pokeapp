package com.vinicius.pokeapp.pokemonlist.data.model

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
    @field:Json(name = "training") val training: Training? = null,
    @field:Json(name = "breedings") val breedings: Breedings? = null,
    @field:Json(name = "baseStats") val baseStats: BaseStats? = null,
    @field:Json(name = "typeDefences") val typeDefenses: TypeDefenses? = null,
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

@JsonClass(generateAdapter = true)
data class TypeDefenses(
    @field:Json(name = "normal") val normal: Double?,
    @field:Json(name = "fire") val fire: Double?,
    @field:Json(name = "water") val water: Double?,
    @field:Json(name = "electric") val electric: Double?,
    @field:Json(name = "grass") val grass: Double?,
    @field:Json(name = "ice") val ice: Double?,
    @field:Json(name = "fighting") val fighting: Double?,
    @field:Json(name = "poison") val poison: Double?,
    @field:Json(name = "ground") val ground: Double?,
    @field:Json(name = "flying") val flying: Double?,
    @field:Json(name = "psychic") val psychic: Double?,
    @field:Json(name = "bug") val bug: Double?,
    @field:Json(name = "rock") val rock: Double?,
    @field:Json(name = "ghost") val ghost: Double?,
    @field:Json(name = "dragon") val dragon: Double?,
    @field:Json(name = "darl") val dark: Double?,
    @field:Json(name = "steel") val steel: Double?,
    @field:Json(name = "fairy") val fairy: Double?,
)