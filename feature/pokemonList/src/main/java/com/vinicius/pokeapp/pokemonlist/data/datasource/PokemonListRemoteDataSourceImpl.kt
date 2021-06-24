package com.vinicius.pokeapp.pokemonlist.data.datasource

import com.vinicius.pokeapp.core.data.Result
import com.vinicius.pokeapp.pokemonlist.data.model.PokemonDataModel
import com.vinicius.pokeapp.service.service.PokeappService
import javax.inject.Inject

class PokemonListRemoteDataSourceImpl @Inject constructor(
    private val pokeappService: PokeappService
) : PokemonListRemoteDataSource {

    override suspend fun fetchPokemons(): Result<List<PokemonDataModel>, String> {
        return try {
            val result = pokeappService.fetchPokemons()

            if (result.isNullOrEmpty()) {
                Result.Success(emptyList())
            } else {
                Result.Success(result.map {
                    PokemonDataModel(
                        id = it.id.toString(),
                        name = it.name,
                        types = it.types,
                        imageUrl = it.imageUrl,
                        description = it.description,
                        species = it.species,
                        height = "${it.height}m",
                        weight = "${it.weight}kg",
                        evYield = it.training?.evYield,
                        catchRate = "${it.training?.catchRate?.value} (${it.training?.catchRate?.text})",
                        baseFriendship = "${it.training?.baseFriendship?.value} (${it.training?.baseFriendship?.text})",
                        baseExp = it.training?.baseExp.toString(),
                        growthRate = it.training?.growthRate,
                    )
                })
            }
        } catch (ex: Exception) {
            Result.Error("")
        }
    }
}