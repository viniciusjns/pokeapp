package com.vinicius.pokeapp.pokemondetail.domain

data class PokemonDomainModel(
    val id: String,
    val name: String,
    val types: List<String>?,
    val imageUrl: String?,
    val description: String?,
    val species: String?,
    val height: Double?,
    val weight: Double?,
    val training: Training?,
    val breedings: Breedings?,
    val baseStats: BaseStats?,
    val typeDefences: TypeDefences?,
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

data class TypeDefences(
    val normal: Int?,
    val fire: Int?,
    val water: Int?,
    val electric: Int?,
    val grass: Int?,
    val ice: Int?,
    val fighting: Int?,
    val poison: Int?,
    val ground: Int?,
    val flying: Int?,
    val psychic: Int?,
    val bug: Int?,
    val rock: Int?,
    val ghost: Int?,
    val dragon: Int?,
    val darl: Int?,
    val steel: Int?,
    val fairy: Int?,
)