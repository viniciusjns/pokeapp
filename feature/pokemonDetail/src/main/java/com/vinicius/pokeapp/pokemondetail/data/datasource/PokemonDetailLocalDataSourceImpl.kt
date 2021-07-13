package com.vinicius.pokeapp.pokemondetail.data.datasource

import com.vinicius.pokeapp.core.data.Result
import com.vinicius.pokeapp.pokemondetail.data.model.*
import com.vinicius.pokeapp.service.PokemonSingleton
import javax.inject.Inject

class PokemonDetailLocalDataSourceImpl @Inject constructor(

) : PokemonDetailLocalDataSource {

    override suspend fun getPokemonById(id: Int): Result<PokemonDataModel, String> {
        try {
            val result = PokemonSingleton.pokemonList[id - 1]
            val pokemonDataModel = PokemonDataModel(
                id = result.id.toString(),
                name = result.name,
                types = result.types,
                imageUrl = result.imageUrl,
                description = result.description,
                species = result.species,
                height = result.height,
                weight = result.weight,
                training = Training(
                    evYield = result.training?.evYield,
                    baseExp = result.training?.baseExp,
                    growthRate = result.training?.growthRate,
                    catchRate = DefaultData(
                        value = result.training?.catchRate?.value,
                        text = result.training?.catchRate?.text
                    ),
                    baseFriendship = DefaultData(
                        value = result.training?.baseFriendship?.value,
                        text = result.training?.baseFriendship?.text
                    )
                ),
                breedings = Breedings(
                    eggGroups = result.breedings?.eggGroups,
                    eggCycles = DefaultData(
                        value = result.breedings?.eggCycles?.value,
                        text = result.breedings?.eggCycles?.text,
                    ),
                    gender = Gender(
                        male = result.breedings?.gender?.male,
                        female = result.breedings?.gender?.female,
                    )
                ),
                baseStats = BaseStats(
                    hp = result.baseStats?.hp,
                    attack = result.baseStats?.attack,
                    defense = result.baseStats?.defense,
                    specialAttack = result.baseStats?.specialAttack,
                    specialDefense = result.baseStats?.specialDefense,
                    speed = result.baseStats?.speed,
                ),
                typeDefences = null
            )
            return Result.Success(pokemonDataModel)
        } catch (ex: Exception) {
            return Result.Error("")
        }
    }
}