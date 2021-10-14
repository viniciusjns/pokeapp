package com.vinicius.pokeapp.pokemondetail.data.model

data class PokemonDetailDataModel(
    val id: String,
    val name: String,
    val types: List<String>?,
    val imageUrl: String?,
    val description: String?,
    val species: String?,
    val height: Double?,
    val weight: Double?,
    val training: Training? = null,
    val breedings: Breedings? = null,
    val baseStats: BaseStats? = null,
    val typeDefenses: TypeDefenses? = null,
)

data class Training(
    val evYield: String?,
    val catchRate: DefaultData?,
    val baseFriendship: DefaultData?,
    val baseExp: Int?,
    val growthRate: String?,
)

data class Breedings(
    val eggGroups: List<String>?,
    val gender: Gender?,
    val eggCycles: DefaultData?,
)

data class Gender(
    val male: Double?,
    val female: Double?,
)

data class DefaultData(
    val value: Int?,
    val text: String?,
)

data class BaseStats(
    val hp: List<Int>?,
    val attack: List<Int>?,
    val defense: List<Int>?,
    val specialAttack: List<Int>?,
    val specialDefense: List<Int>?,
    val speed: List<Int>?,
)

data class TypeDefenses(
    val normal: Double?,
    val fire: Double?,
    val water: Double?,
    val electric: Double?,
    val grass: Double?,
    val ice: Double?,
    val fighting: Double?,
    val poison: Double?,
    val ground: Double?,
    val flying: Double?,
    val psychic: Double?,
    val bug: Double?,
    val rock: Double?,
    val ghost: Double?,
    val dragon: Double?,
    val dark: Double?,
    val steel: Double?,
    val fairy: Double?,
)
