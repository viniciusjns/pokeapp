package com.vinicius.pokeapp.pokemonlist.data.datasource

import com.vinicius.pokeapp.pokemonlist.data.mapper.PokemonListDataMapper
import com.vinicius.pokeapp.pokemonlist.data.model.PokemonListDataModel
import com.vinicius.pokeapp.service.PokemonSingleton
import com.vinicius.pokeapp.core.util.ResultError
import com.vinicius.pokeapp.core.util.Result
import javax.inject.Inject

class PokemonListLocalDataSourceImpl @Inject constructor(
    private val pokemonListDataMapper: PokemonListDataMapper
) : PokemonListLocalDataSource {

    override suspend fun getPokemons(): Result<List<PokemonListDataModel>, ResultError> {
        val result = PokemonSingleton.pokemonList.map {
            pokemonListDataMapper.mapFrom(it)
        }
        return if (result.isNullOrEmpty()) {
            Result.Error(ResultError.GenericError)
        } else
            Result.Success(result)
    }
}