package com.vinicius.pokeapp.pokemondetail.presentation.mapper

import androidx.core.graphics.toColorInt
import com.vinicius.pokeapp.core.mapper.Mapper
import com.vinicius.pokeapp.core.ui.Colors
import com.vinicius.pokeapp.pokemondetail.domain.model.PokemonDetailDomainModel
import com.vinicius.pokeapp.pokemondetail.presentation.model.*
import javax.inject.Inject

class PokemonDetailPresentationMapper @Inject constructor(
    
): Mapper<PokemonDetailDomainModel, PokemonDetailUiModel> {
    override fun mapFrom(from: PokemonDetailDomainModel): PokemonDetailUiModel {
        return PokemonDetailUiModel(
            id = from.id,
            name = from.name,
            types = from.types,
            imageUrl = from.imageUrl,
            pokemonAboutModel = PokemonAboutModel(
                description = from.description,
                species = from.species,
                height = "${from.height}m",
                weight = "${from.weight}kg",
                evYield = from.training?.evYield,
                catchRate = "${from.training?.catchRate?.value} (${from.training?.catchRate?.text})",
                baseFriendship = "${from.training?.baseFriendship?.value} (${from.training?.baseFriendship?.text})",
                baseExp = from.training?.baseExp.toString(),
                growthRate = from.training?.growthRate,
                gender = "${from.breedings?.gender?.male}%, ${from.breedings?.gender?.female}%",
                eggGroups = from.breedings?.eggGroups?.joinToString(separator = ", ")?.replaceFirstChar{ it.uppercase() },
                eggCycles = "${from.breedings?.eggCycles?.value} (${from.breedings?.eggCycles?.text})",
                baseColor = getBaseColor(from)
            ),
            pokemonStatsModel = PokemonStatsModel(
                hp = from.baseStats?.hp?.map { hp -> hp.toString() },
                attack = from.baseStats?.attack?.map { atk -> atk.toString() },
                defense = from.baseStats?.defense?.map { def -> def.toString() },
                specialAttack = from.baseStats?.specialAttack?.map { sAtk -> sAtk.toString() },
                specialDefense = from.baseStats?.specialDefense?.map { sDef -> sDef.toString() },
                speed = from.baseStats?.speed?.map { spd -> spd.toString() },
                typeDefenses = listOf(
                    Pair(TypeDefense.NORMAL, from.typeDefenses?.normal?.toString() ?: ""),
                    Pair(TypeDefense.FIRE, from.typeDefenses?.fire?.toString() ?: ""),
                    Pair(TypeDefense.WATER, from.typeDefenses?.water?.toString() ?: ""),
                    Pair(TypeDefense.ELECTRIC, from.typeDefenses?.electric?.toString() ?: ""),
                    Pair(TypeDefense.GRASS, from.typeDefenses?.grass?.toString() ?: ""),
                    Pair(TypeDefense.ICE, from.typeDefenses?.ice?.toString() ?: ""),
                    Pair(TypeDefense.FIGHTING, from.typeDefenses?.fighting?.toString() ?: ""),
                    Pair(TypeDefense.POISON, from.typeDefenses?.poison?.toString() ?: ""),
                    Pair(TypeDefense.GROUND, from.typeDefenses?.ground?.toString() ?: ""),
                    Pair(TypeDefense.FLYING, from.typeDefenses?.flying?.toString() ?: ""),
                    Pair(TypeDefense.PSYCHIC, from.typeDefenses?.psychic?.toString() ?: ""),
                    Pair(TypeDefense.BUG, from.typeDefenses?.bug?.toString() ?: ""),
                    Pair(TypeDefense.ROCK, from.typeDefenses?.rock?.toString() ?: ""),
                    Pair(TypeDefense.GHOST, from.typeDefenses?.ghost?.toString() ?: ""),
                    Pair(TypeDefense.DRAGON, from.typeDefenses?.dragon?.toString() ?: ""),
                    Pair(TypeDefense.DARK, from.typeDefenses?.dark?.toString() ?: ""),
                    Pair(TypeDefense.STEEL, from.typeDefenses?.steel?.toString() ?: ""),
                    Pair(TypeDefense.FAIRY, from.typeDefenses?.fairy?.toString() ?: ""),
                ),
                baseColor = getBaseColor(from)
            ),
            pokemonEvolutionModel = PokemonEvolutionModel()
        )
    }

    private fun getBaseColor(from: PokemonDetailDomainModel): Int? =
        from.types?.let {
            Colors.valueOf(it[0].uppercase()).type.toColorInt()
        }
}