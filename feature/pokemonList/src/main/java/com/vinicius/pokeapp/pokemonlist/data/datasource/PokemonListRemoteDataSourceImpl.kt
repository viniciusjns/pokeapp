package com.vinicius.pokeapp.pokemonlist.data.datasource

import com.vinicius.pokeapp.pokemonlist.data.mapper.PokemonListDataMapper
import com.vinicius.pokeapp.pokemonlist.data.model.PokemonListDataModel
import com.vinicius.pokeapp.service.PokemonSingleton
import com.vinicius.pokeapp.core.util.ResultError
import com.vinicius.pokeapp.core.util.Result
import com.vinicius.pokeapp.service.service.PokeappService
import com.vinicius.pokeapp.service.util.safeApiCall
import javax.inject.Inject

class PokemonListRemoteDataSourceImpl @Inject constructor(
    private val pokeappService: PokeappService,
    private val pokemonListDataMapper: PokemonListDataMapper
) : PokemonListRemoteDataSource {

    override suspend fun getPokemons(): Result<List<PokemonListDataModel>, ResultError> =
        safeApiCall {
            pokeappService.fetchPokemons()
        }.onSuccess {
            PokemonSingleton.pokemonList.addAll(it)
        }.mapSuccess {
            it.map { response ->
                pokemonListDataMapper.mapFrom(response)
            }
        }
}