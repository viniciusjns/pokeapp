package com.vinicius.pokeapp.pokemonlist.data.datasource

import com.vinicius.pokeapp.service.response.Result
import com.vinicius.pokeapp.pokemonlist.data.mapper.PokemonListDataMapper
import com.vinicius.pokeapp.pokemonlist.data.model.PokemonListDataModel
import com.vinicius.pokeapp.service.PokemonSingleton
import com.vinicius.pokeapp.service.service.PokeappService
import javax.inject.Inject

class PokemonListRemoteDataSourceImpl @Inject constructor(
    private val pokeappService: PokeappService,
    private val pokemonListDataMapper: PokemonListDataMapper
) : PokemonListRemoteDataSource {

    override suspend fun fetchPokemons(): Result<List<PokemonListDataModel>, String> {
        return try {
            val result = pokeappService.fetchPokemons()

            if (result.isNullOrEmpty()) {
                Result.Success(emptyList())
            } else {
                PokemonSingleton.pokemonList.addAll(result)
                Result.Success(result.map {
                    pokemonListDataMapper.mapFrom(it)
                })
            }
        } catch (ex: Exception) {
            Result.Error("")
        }
    }
}