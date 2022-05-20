package com.vinicius.pokeapp.pokemondetail.presentation.mapper

import androidx.core.graphics.toColorInt
import com.vinicius.pokeapp.core.ui.Colors
import com.vinicius.pokeapp.pokemondetail.domain.model.PokemonDetailDomainModel
import com.vinicius.pokeapp.pokemondetail.presentation.model.*

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
        eggGroups = breedings?.eggGroups?.joinToString(separator = ", ")?.replaceFirstChar{ it.uppercase() },
        eggCycles = "${breedings?.eggCycles?.value} (${breedings?.eggCycles?.text})",
        baseColor = getBaseColor()
    ),
    pokemonStatsModel = PokemonStatsModel(
        hp = baseStats?.hp?.map { hp -> hp.toString() },
        attack = baseStats?.attack?.map { atk -> atk.toString() },
        defense = baseStats?.defense?.map { def -> def.toString() },
        specialAttack = baseStats?.specialAttack?.map { sAtk -> sAtk.toString() },
        specialDefense = baseStats?.specialDefense?.map { sDef -> sDef.toString() },
        speed = baseStats?.speed?.map { spd -> spd.toString() },
        typeDefenses = listOf(
            Pair(TypeDefense.NORMAL, typeDefenses?.normal?.toString() ?: ""),
            Pair(TypeDefense.FIRE, typeDefenses?.fire?.toString() ?: ""),
            Pair(TypeDefense.WATER, typeDefenses?.water?.toString() ?: ""),
            Pair(TypeDefense.ELECTRIC, typeDefenses?.electric?.toString() ?: ""),
            Pair(TypeDefense.GRASS, typeDefenses?.grass?.toString() ?: ""),
            Pair(TypeDefense.ICE, typeDefenses?.ice?.toString() ?: ""),
            Pair(TypeDefense.FIGHTING, typeDefenses?.fighting?.toString() ?: ""),
            Pair(TypeDefense.POISON, typeDefenses?.poison?.toString() ?: ""),
            Pair(TypeDefense.GROUND, typeDefenses?.ground?.toString() ?: ""),
            Pair(TypeDefense.FLYING, typeDefenses?.flying?.toString() ?: ""),
            Pair(TypeDefense.PSYCHIC, typeDefenses?.psychic?.toString() ?: ""),
            Pair(TypeDefense.BUG, typeDefenses?.bug?.toString() ?: ""),
            Pair(TypeDefense.ROCK, typeDefenses?.rock?.toString() ?: ""),
            Pair(TypeDefense.GHOST, typeDefenses?.ghost?.toString() ?: ""),
            Pair(TypeDefense.DRAGON, typeDefenses?.dragon?.toString() ?: ""),
            Pair(TypeDefense.DARK, typeDefenses?.dark?.toString() ?: ""),
            Pair(TypeDefense.STEEL, typeDefenses?.steel?.toString() ?: ""),
            Pair(TypeDefense.FAIRY, typeDefenses?.fairy?.toString() ?: ""),
        ),
        baseColor = getBaseColor()
    ),
    pokemonEvolutionModel = PokemonEvolutionModel()
)

private fun PokemonDetailDomainModel.getBaseColor(): Int? =
    types?.let {
        Colors.valueOf(it[0].uppercase()).type.toColorInt()
    }