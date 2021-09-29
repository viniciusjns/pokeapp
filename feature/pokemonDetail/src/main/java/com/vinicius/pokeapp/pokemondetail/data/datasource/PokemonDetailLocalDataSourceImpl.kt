package com.vinicius.pokeapp.pokemondetail.data.datasource

import com.vinicius.pokeapp.service.response.Result
import com.vinicius.pokeapp.pokemondetail.data.mapper.PokemonDetailDataMapper
import com.vinicius.pokeapp.pokemondetail.data.model.*
import com.vinicius.pokeapp.service.PokemonSingleton
import javax.inject.Inject

class PokemonDetailLocalDataSourceImpl @Inject constructor(
    private val pokemonDetailDataMapper: PokemonDetailDataMapper
) : PokemonDetailLocalDataSource {

    override suspend fun getPokemonById(id: Int): Result<PokemonDetailDataModel, String> {
        return try {
            val result = PokemonSingleton.pokemonList[id - 1]
            val pokemonDataModel = pokemonDetailDataMapper.mapFrom(result)
            Result.Success(pokemonDataModel)
        } catch (ex: Exception) {
            Result.Error("")
        }
    }
}