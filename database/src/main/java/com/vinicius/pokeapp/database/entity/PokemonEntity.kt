package com.vinicius.pokeapp.database.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_pokemon")
data class PokemonEntity(
    @PrimaryKey(autoGenerate = false) val id: Int,
    val name: String,
    val types: List<String>?,
    val imageUrl: String?,
    val description: String?,
    val species: String?,
    val height: Double?,
    val weight: Double?,
    @Embedded val training: Training? = null,
    @Embedded val breedings: Breedings? = null,
    @Embedded val baseStats: BaseStats? = null,
    @Embedded val typeDefenses: TypeDefenses? = null,
)

data class Training(
    val evYield: String?,
    @Embedded(prefix = "catchRate") val catchRate: DefaultData?,
    @Embedded(prefix = "baseFriendship") val baseFriendship: DefaultData?,
    val baseExp: Int?,
    val growthRate: String?,
)

data class DefaultData(
    val value: Int?,
    val text: String?,
)

data class Breedings(
    val eggGroups: List<String>?,
    @Embedded val gender: Gender?,
    @Embedded(prefix = "eggCycles") val eggCycles: DefaultData?,
)

data class Gender(
    val male: Double?,
    val female: Double?,
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