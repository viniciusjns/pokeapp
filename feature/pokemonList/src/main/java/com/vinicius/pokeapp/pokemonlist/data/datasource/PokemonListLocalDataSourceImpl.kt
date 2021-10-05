package com.vinicius.pokeapp.pokemonlist.data.datasource

import com.vinicius.pokeapp.pokemonlist.data.mapper.PokemonListDataMapper
import com.vinicius.pokeapp.pokemonlist.data.model.PokemonListDataModel
import com.vinicius.pokeapp.service.PokemonSingleton
import com.vinicius.pokeapp.service.response.ResultWrapper
import javax.inject.Inject

class PokemonListLocalDataSourceImpl @Inject constructor(
    private val pokemonListDataMapper: PokemonListDataMapper
) : PokemonListLocalDataSource {

    override suspend fun getPokemons(): ResultWrapper<List<PokemonListDataModel>> {
        val result = PokemonSingleton.pokemonList.map {
            pokemonListDataMapper.mapFrom(it)
        }
        return if (result.isNullOrEmpty()) {
            ResultWrapper.Error.GenericError
        } else
            ResultWrapper.Success(result)
    }
}