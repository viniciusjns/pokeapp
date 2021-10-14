package com.vinicius.pokeapp.pokemonlist.data.repository

import com.vinicius.pokeapp.pokemonlist.data.datasource.PokemonListLocalDataSource
import com.vinicius.pokeapp.pokemonlist.data.datasource.PokemonListRemoteDataSource
import com.vinicius.pokeapp.pokemonlist.data.model.PokemonListDataModel
import com.vinicius.pokeapp.pokemonlist.domain.repository.PokemonListRepository
import com.vinicius.pokeapp.core.util.Result
import com.vinicius.pokeapp.core.util.ResultError
import com.vinicius.pokeapp.pokemonlist.data.mapper.PokemonEntityToPokemonListDataMapper
import com.vinicius.pokeapp.pokemonlist.data.mapper.PokemonResponseToPokemonListDataMapper
import com.vinicius.pokeapp.pokemonlist.data.mapper.PokemonResponseToPokemonEntityMapper
import javax.inject.Inject

class PokemonListRepositoryImpl @Inject constructor(
    private val remoteDataSource: PokemonListRemoteDataSource,
    private val localDataSource: PokemonListLocalDataSource,
    private val pokemonResponseToPokemonListDataMapper: PokemonResponseToPokemonListDataMapper,
    private val pokemonResponseToPokemonEntityMapper: PokemonResponseToPokemonEntityMapper,
    private val pokemonEntityToPokemonListDataMapper: PokemonEntityToPokemonListDataMapper
) : PokemonListRepository {

    override suspend fun getPokemons(): Result<List<PokemonListDataModel>, ResultError> {
        val result = localDataSource.getPokemons()
        return if (result.isNullOrEmpty()) {
            remoteDataSource.getPokemons().onSuccess {
                localDataSource.savePokemons(
                    it.map { response ->
                        pokemonResponseToPokemonEntityMapper.mapFrom(response)
                    }
                )
            }.mapSuccess {
                it.map { response ->
                    pokemonResponseToPokemonListDataMapper.mapFrom(response)
                }
            }
        } else {
            val entityToData = result.map { pokemonEntity ->
                pokemonEntityToPokemonListDataMapper.mapFrom(pokemonEntity)
            }
            Result.Success(entityToData)
        }
    }
}