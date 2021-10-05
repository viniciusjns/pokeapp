package com.vinicius.pokeapp.pokemonlist.data.datasource

import com.vinicius.pokeapp.pokemonlist.data.mapper.PokemonListDataMapper
import com.vinicius.pokeapp.pokemonlist.data.model.PokemonListDataModel
import com.vinicius.pokeapp.service.PokemonSingleton
import com.vinicius.pokeapp.service.response.ResultWrapper
import com.vinicius.pokeapp.service.service.PokeappService
import com.vinicius.pokeapp.service.util.safeApiCall
import javax.inject.Inject

class PokemonListRemoteDataSourceImpl @Inject constructor(
    private val pokeappService: PokeappService,
    private val pokemonListDataMapper: PokemonListDataMapper
) : PokemonListRemoteDataSource {

    override suspend fun getPokemons(): ResultWrapper<List<PokemonListDataModel>> =
        safeApiCall {
            val result = pokeappService.fetchPokemons()
            PokemonSingleton.pokemonList.addAll(result)
            result.map {
                pokemonListDataMapper.mapFrom(it)
            }
        }
}