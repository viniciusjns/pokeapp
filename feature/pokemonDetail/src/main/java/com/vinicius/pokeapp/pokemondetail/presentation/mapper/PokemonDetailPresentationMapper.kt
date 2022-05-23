package com.vinicius.pokeapp.pokemondetail.presentation.mapper

import android.graphics.Color
import androidx.core.graphics.toColorInt
import com.vinicius.pokeapp.core.ui.Colors
import com.vinicius.pokeapp.pokemondetail.domain.model.PokemonDetailDomainModel
import com.vinicius.pokeapp.pokemondetail.presentation.model.*

private const val EMPTY_STRING = ""
private const val DEFAULT_COLOR = Color.GRAY

fun PokemonDetailDomainModel.toPokemonDetailUiModel(): PokemonDetailUiModel = PokemonDetailUiModel(
    id = id,
    name = name,
    types = types,
    imageUrl = imageUrl,
    pokemonAboutModel = PokemonAboutModel(
        description = description,
        species = species,
        height = "${height}m",
        weight = "${weight}kg",
        evYield = training?.evYield,
        catchRate = "${training?.catchRate?.value} (${training?.catchRate?.text})",
        baseFriendship = "${training?.baseFriendship?.value} (${training?.baseFriendship?.text})",
        baseExp = training?.baseExp.toString(),
        growthRate = training?.growthRate,
        gender = "${breedings?.gender?.male}%, ${breedings?.gender?.female}%",
        eggGroups = breedings?.eggGroups?.joinToString(separator = ", ")
            ?.replaceFirstChar { it.uppercase() },
        eggCycles = "${breedings?.eggCycles?.value} (${breedings?.eggCycles?.text})",
        baseColor = getBaseColor()
    ),
    pokemonStatsModel = PokemonStatsModel(
        attributes = listOf(
            getAttributes("HP", baseStats?.hp),
            getAttributes("Attack", baseStats?.attack),
            getAttributes("Defense", baseStats?.defense),
            getAttributes("Sp. Atk", baseStats?.specialAttack),
            getAttributes("Sp. Def", baseStats?.specialDefense),
            getAttributes("Speed", baseStats?.speed),
        ),
        typeDefenses = listOf(
            Pair(TypeDefense.NORMAL, typeDefenses?.normal?.toString() ?: EMPTY_STRING),
            Pair(TypeDefense.FIRE, typeDefenses?.fire?.toString() ?: EMPTY_STRING),
            Pair(TypeDefense.WATER, typeDefenses?.water?.toString() ?: EMPTY_STRING),
            Pair(TypeDefense.ELECTRIC, typeDefenses?.electric?.toString() ?: EMPTY_STRING),
            Pair(TypeDefense.GRASS, typeDefenses?.grass?.toString() ?: EMPTY_STRING),
            Pair(TypeDefense.ICE, typeDefenses?.ice?.toString() ?: EMPTY_STRING),
            Pair(TypeDefense.FIGHTING, typeDefenses?.fighting?.toString() ?: EMPTY_STRING),
            Pair(TypeDefense.POISON, typeDefenses?.poison?.toString() ?: EMPTY_STRING),
            Pair(TypeDefense.GROUND, typeDefenses?.ground?.toString() ?: EMPTY_STRING),
            Pair(TypeDefense.FLYING, typeDefenses?.flying?.toString() ?: EMPTY_STRING),
            Pair(TypeDefense.PSYCHIC, typeDefenses?.psychic?.toString() ?: EMPTY_STRING),
            Pair(TypeDefense.BUG, typeDefenses?.bug?.toString() ?: EMPTY_STRING),
            Pair(TypeDefense.ROCK, typeDefenses?.rock?.toString() ?: EMPTY_STRING),
            Pair(TypeDefense.GHOST, typeDefenses?.ghost?.toString() ?: EMPTY_STRING),
            Pair(TypeDefense.DRAGON, typeDefenses?.dragon?.toString() ?: EMPTY_STRING),
            Pair(TypeDefense.DARK, typeDefenses?.dark?.toString() ?: EMPTY_STRING),
            Pair(TypeDefense.STEEL, typeDefenses?.steel?.toString() ?: EMPTY_STRING),
            Pair(TypeDefense.FAIRY, typeDefenses?.fairy?.toString() ?: EMPTY_STRING),
        ),
        baseColor = getBaseColor()
    ),
    pokemonEvolutionModel = PokemonEvolutionModel()
)

private fun getAttributes(attributeName: String, stats: List<Int>?): PokemonAttributesUiModel =
    PokemonAttributesUiModel(
        attributeName = attributeName,
        currentValue = stats?.get(0) ?: 0,
        minValue = stats?.get(1) ?: 0,
        maxValue = stats?.get(2) ?: 0
    )

private fun PokemonDetailDomainModel.getBaseColor(): Int =
    types?.let {
        Colors.valueOf(it[0].uppercase()).type.toColorInt()
    } ?: DEFAULT_COLOR