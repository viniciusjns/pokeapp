package com.vinicius.pokeapp.pokemonlist.data.repository

import com.vinicius.pokeapp.core.util.Result
import com.vinicius.pokeapp.core.util.ResultError
import com.vinicius.pokeapp.pokemonlist.domain.repository.PokemonListRepository
import com.vinicius.pokeapp.pokemonlist.domain.model.PokemonListDomainModel
import com.vinicius.pokeapp.pokemonlist.data.datasource.PokemonListLocalDataSource
import com.vinicius.pokeapp.pokemonlist.data.datasource.PokemonListRemoteDataSource
import com.vinicius.pokeapp.pokemonlist.data.mapper.toPokemonEntity
import com.vinicius.pokeapp.pokemonlist.data.mapper.toPokemonListDomainModel
import javax.inject.Inject

class PokemonListRepositoryImpl @Inject constructor(
    private val remoteDataSource: PokemonListRemoteDataSource,
    private val localDataSource: PokemonListLocalDataSource,
) : PokemonListRepository {

    override suspend fun getPokemons(): Result<List<PokemonListDomainModel>, ResultError> {
        val result = localDataSource.getPokemons()
        return if (result.isNullOrEmpty()) {
            remoteDataSource.getPokemons().onSuccess {
                localDataSource.savePokemons(
                    it.map { response ->
                        response.toPokemonEntity()
                    }
                )
            }.mapSuccess {
                it.map { response ->
                    response.toPokemonListDomainModel()
                }
            }
        } else {
            val entityToDomain = result.map { pokemonEntity ->
                pokemonEntity.toPokemonListDomainModel()
            }
            Result.Success(entityToDomain)
        }
    }
}