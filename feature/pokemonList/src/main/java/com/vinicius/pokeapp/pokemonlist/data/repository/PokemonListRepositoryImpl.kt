package com.vinicius.pokeapp.pokemonlist.data.repository

import com.vinicius.pokeapp.core.data.Result
import com.vinicius.pokeapp.pokemonlist.data.datasource.PokemonListRemoteDataSourceImpl
import com.vinicius.pokeapp.pokemonlist.data.model.PokemonDataModel
import javax.inject.Inject

class PokemonListRepositoryImpl @Inject constructor(
    private val remoteDataSourceImpl: PokemonListRemoteDataSourceImpl
) : PokemonListRepository {

    override suspend fun fetchPokemons(): Result<List<PokemonDataModel>, String> {
        return remoteDataSourceImpl.fetchPokemons()
    }
}