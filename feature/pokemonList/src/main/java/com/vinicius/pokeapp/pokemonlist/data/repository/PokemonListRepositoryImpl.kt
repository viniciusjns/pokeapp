package com.vinicius.pokeapp.pokemonlist.data.repository

import com.vinicius.pokeapp.core.data.Result
import com.vinicius.pokeapp.pokemonlist.data.datasource.PokemonListLocalDataSource
import com.vinicius.pokeapp.pokemonlist.data.datasource.PokemonListRemoteDataSource
import com.vinicius.pokeapp.pokemonlist.data.model.PokemonListDataModel
import javax.inject.Inject

class PokemonListRepositoryImpl @Inject constructor(
    private val remoteDataSource: PokemonListRemoteDataSource,
    private val localDataSource: PokemonListLocalDataSource,
) : PokemonListRepository {

    override suspend fun fetchPokemons(): Result<List<PokemonListDataModel>, String> {
        val result = localDataSource.fetchPokemons()
        if (result.handleResult().isNullOrEmpty()) {
            return remoteDataSource.fetchPokemons()
        }
        return result
    }
}