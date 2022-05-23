package com.vinicius.pokeapp.pokemondetail.presentation.mapper

import android.graphics.Color
import androidx.core.graphics.toColorInt
import com.vinicius.pokeapp.core.ui.Colors
import com.vinicius.pokeapp.pokemondetail.domain.model.PokemonDetailDomainModel
import com.vinicius.pokeapp.pokemondetail.presentation.model.*

private const val EMPTY_STRING = ""
private const val EMPTY_VALUE = 0
private const val DEFAULT_COLOR = Color.GRAY

fun PokemonDetailDomainModel.toPokemonDetailUiModel(): PokemonDetailUiModel = PokemonDetailUiModel(
    id = id,
    name = name,
    types = types,
    imageUrl = imageUrl,
    pokemonAboutUiModel = PokemonAboutUiModel(
        description = description,
        species = species,
        height = height,
        weight = weight,
        evYield = training?.evYield,
        catchRate = DefaultDataUiModel(
            value = training?.catchRate?.value,
            text = training?.catchRate?.text
        ),
        baseFriendship = DefaultDataUiModel(
            value = training?.baseFriendship?.value,
            text = training?.baseFriendship?.text
        ),
        baseExp = training?.baseExp.toString(),
        growthRate = training?.growthRate,
        male = breedings?.gender?.male,
        female = breedings?.gender?.female,
        eggGroups = breedings?.eggGroups?.joinToString(separator = ", ")
            ?.replaceFirstChar { it.uppercase() },
        eggCycles = DefaultDataUiModel(
            value = breedings?.eggCycles?.value,
            text = breedings?.eggCycles?.text
        ),
        baseColor = getBaseColor()
    ),
    pokemonStatsUiModel = PokemonStatsUiModel(
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
    pokemonEvolutionUiModel = PokemonEvolutionUiModel()
)

private fun getAttributes(attributeName: String, stats: List<Int>?): PokemonAttributesUiModel =
    PokemonAttributesUiModel(
        attributeName = attributeName,
        currentValue = stats?.get(0) ?: EMPTY_VALUE,
        minValue = stats?.get(1) ?: EMPTY_VALUE,
        maxValue = stats?.get(2) ?: EMPTY_VALUE
    )

private fun PokemonDetailDomainModel.getBaseColor(): Int =
    types?.let {
        Colors.valueOf(it[0].uppercase()).type.toColorInt()
    } ?: DEFAULT_COLOR