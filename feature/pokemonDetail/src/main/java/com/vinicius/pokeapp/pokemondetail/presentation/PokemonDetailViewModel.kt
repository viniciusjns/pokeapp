package com.vinicius.pokeapp.pokemondetail.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vinicius.pokeapp.pokemondetail.domain.PokemonDetailUseCase
import com.vinicius.pokeapp.pokemondetail.domain.PokemonDomainModel
import com.vinicius.pokeapp.pokemondetail.presentation.model.PokemonAboutModel
import com.vinicius.pokeapp.pokemondetail.presentation.model.PokemonEvolutionModel
import com.vinicius.pokeapp.pokemondetail.presentation.model.PokemonStatsModel
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
                        types = it.types,
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
                        hp = it.baseStats?.hp,
                        attack = it.baseStats?.attack,
                        defense = it.baseStats?.defense,
                        specialAttack = it.baseStats?.specialAttack,
                        specialDefense = it.baseStats?.specialDefense,
                        spped = it.baseStats?.speed
                    ),
                    pokemonEvolutionModel = PokemonEvolutionModel()
                )
                pokemonDetailLiveData.value = pokemonUiModel
            }
        }
    }
}