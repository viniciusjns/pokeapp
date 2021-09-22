package com.vinicius.pokeapp.pokemondetail.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vinicius.pokeapp.pokemondetail.domain.PokemonDetailUseCase
import com.vinicius.pokeapp.pokemondetail.presentation.model.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class PokemonDetailViewModel @Inject constructor(
    private val pokemonDetailUseCase: PokemonDetailUseCase
) : ViewModel() {

    val pokemonDetailLiveData = MutableLiveData<PokemonDetailUiModel?>()

    fun getPokemonById(id: Int) {
        viewModelScope.launch {
            pokemonDetailUseCase.getPokemonById(id).onSuccess {
                val pokemonUiModel = PokemonDetailUiModel(
                    id = it.id,
                    name = it.name,
                    types = it.types,
                    imageUrl = it.imageUrl,
                    pokemonAboutModel = PokemonAboutModel(
                        description = it.description,
                        species = it.species,
                        height = "${it.height}m",
                        weight = "${it.weight}kg",
                        evYield = it.training?.evYield,
                        catchRate = "${it.training?.catchRate?.value} (${it.training?.catchRate?.text})",
                        baseFriendship = "${it.training?.baseFriendship?.value} (${it.training?.baseFriendship?.text})",
                        baseExp = it.training?.baseExp.toString(),
                        growthRate = it.training?.growthRate,
                        gender = "${it.breedings?.gender?.male}%, ${it.breedings?.gender?.female}%",
                        eggGroups = it.breedings?.eggGroups?.joinToString(separator = ", ")?.capitalize(),
                        eggCycles = "${it.breedings?.eggCycles?.value} (${it.breedings?.eggCycles?.text})",
                    ),
                    pokemonStatsModel = PokemonStatsModel(
                        hp = it.baseStats?.hp?.map { hp -> hp.toString() },
                        attack = it.baseStats?.attack?.map { atk -> atk.toString() },
                        defense = it.baseStats?.defense?.map { def -> def.toString() },
                        specialAttack = it.baseStats?.specialAttack?.map { sAtk -> sAtk.toString() },
                        specialDefense = it.baseStats?.specialDefense?.map { sDef -> sDef.toString() },
                        speed = it.baseStats?.speed?.map { spd -> spd.toString() },
                        typeDefenses = listOf(
                            Pair(TypeDefense.NORMAL, it.typeDefenses?.normal?.toString() ?: ""),
                            Pair(TypeDefense.FIRE, it.typeDefenses?.fire?.toString() ?: ""),
                            Pair(TypeDefense.WATER, it.typeDefenses?.water?.toString() ?: ""),
                            Pair(TypeDefense.ELECTRIC, it.typeDefenses?.electric?.toString() ?: ""),
                            Pair(TypeDefense.GRASS, it.typeDefenses?.grass?.toString() ?: ""),
                            Pair(TypeDefense.ICE, it.typeDefenses?.ice?.toString() ?: ""),
                            Pair(TypeDefense.FIGHTING, it.typeDefenses?.fighting?.toString() ?: ""),
                            Pair(TypeDefense.POISON, it.typeDefenses?.poison?.toString() ?: ""),
                            Pair(TypeDefense.GROUND, it.typeDefenses?.ground?.toString() ?: ""),
                            Pair(TypeDefense.FLYING, it.typeDefenses?.flying?.toString() ?: ""),
                            Pair(TypeDefense.PSYCHIC, it.typeDefenses?.psychic?.toString() ?: ""),
                            Pair(TypeDefense.BUG, it.typeDefenses?.bug?.toString() ?: ""),
                            Pair(TypeDefense.ROCK, it.typeDefenses?.rock?.toString() ?: ""),
                            Pair(TypeDefense.GHOST, it.typeDefenses?.ghost?.toString() ?: ""),
                            Pair(TypeDefense.DRAGON, it.typeDefenses?.dragon?.toString() ?: ""),
                            Pair(TypeDefense.DARK, it.typeDefenses?.dark?.toString() ?: ""),
                            Pair(TypeDefense.STEEL, it.typeDefenses?.steel?.toString() ?: ""),
                            Pair(TypeDefense.FAIRY, it.typeDefenses?.fairy?.toString() ?: ""),
                        )
                    ),
                    pokemonEvolutionModel = PokemonEvolutionModel()
                )
                pokemonDetailLiveData.value = pokemonUiModel
            }
        }
    }
}