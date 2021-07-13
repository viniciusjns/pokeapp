package com.vinicius.pokeapp.pokemonlist.data.datasource

import com.vinicius.pokeapp.core.data.Result
import com.vinicius.pokeapp.pokemonlist.data.model.PokemonListDataModel
import com.vinicius.pokeapp.service.PokemonSingleton
import com.vinicius.pokeapp.service.service.PokeappService
import javax.inject.Inject

class PokemonListRemoteDataSourceImpl @Inject constructor(
    private val pokeappService: PokeappService
) : PokemonListRemoteDataSource {

    override suspend fun fetchPokemons(): Result<List<PokemonListDataModel>, String> {
        return try {
            val result = pokeappService.fetchPokemons()

            if (result.isNullOrEmpty()) {
                Result.Success(emptyList())
            } else {
                PokemonSingleton.pokemonList.addAll(result)
                Result.Success(result.map {
                    PokemonListDataModel(
                        id = it.id.toString(),
                        name = it.name,
                        types = it.types,
                        imageUrl = it.imageUrl,
                    )
                })
            }
        } catch (ex: Exception) {
            Result.Error("")
        }
    }
}