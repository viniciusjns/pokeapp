package com.vinicius.pokeapp.pokemonlist.data.repository

import com.vinicius.pokeapp.pokemonlist.data.datasource.PokemonListLocalDataSource
import com.vinicius.pokeapp.pokemonlist.data.datasource.PokemonListRemoteDataSource
import com.vinicius.pokeapp.pokemonlist.data.model.PokemonListDataModel
import com.vinicius.pokeapp.pokemonlist.domain.repository.PokemonListRepository
import com.vinicius.pokeapp.service.response.ResultWrapper
import javax.inject.Inject

class PokemonListRepositoryImpl @Inject constructor(
    private val remoteDataSource: PokemonListRemoteDataSource,
    private val localDataSource: PokemonListLocalDataSource,
) : PokemonListRepository {

    override suspend fun getPokemons(): ResultWrapper<List<PokemonListDataModel>> {
        return when(val result = localDataSource.getPokemons()) {
            is ResultWrapper.Success -> {
                result
            }
            else -> {
                remoteDataSource.getPokemons()
            }
        }
    }
}