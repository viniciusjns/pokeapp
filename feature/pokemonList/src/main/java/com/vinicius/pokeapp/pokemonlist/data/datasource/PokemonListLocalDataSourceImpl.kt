package com.vinicius.pokeapp.pokemonlist.data.datasource

import com.vinicius.pokeapp.service.response.Result
import com.vinicius.pokeapp.pokemonlist.data.mapper.PokemonListDataMapper
import com.vinicius.pokeapp.pokemonlist.data.model.PokemonListDataModel
import com.vinicius.pokeapp.service.PokemonSingleton
import javax.inject.Inject

class PokemonListLocalDataSourceImpl @Inject constructor(
    private val pokemonListDataMapper: PokemonListDataMapper
) : PokemonListLocalDataSource {

    override suspend fun fetchPokemons(): Result<List<PokemonListDataModel>, String> {
        val result = PokemonSingleton.pokemonList.map {
            pokemonListDataMapper.mapFrom(it)
        }
        return if (result.isNullOrEmpty()) {
            Result.Error("")
        } else
            Result.Success(result)
    }
}