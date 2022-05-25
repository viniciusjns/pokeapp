package com.vinicius.pokeapp.pokemondetail.data.repository

import com.vinicius.pokeapp.core.util.Result
import com.vinicius.pokeapp.core.util.ResultError
import com.vinicius.pokeapp.pokemondetail.data.datasource.PokemonDetailLocalDataSource
import com.vinicius.pokeapp.pokemondetail.data.datasource.PokemonDetailRemoteDataSource
import com.vinicius.pokeapp.pokemondetail.data.mapper.toPokemonDetailDomainModel
import com.vinicius.pokeapp.pokemondetail.data.mapper.toPokemonEvolutionDomainModel
import com.vinicius.pokeapp.pokemondetail.data.mapper.toPokemonSpecieDomainModel
import com.vinicius.pokeapp.pokemondetail.data.model.ChainResponse
import com.vinicius.pokeapp.pokemondetail.domain.model.PokemonDetailDomainModel
import com.vinicius.pokeapp.pokemondetail.domain.model.PokemonEvolutionDomainModel
import com.vinicius.pokeapp.pokemondetail.domain.model.PokemonSpecieDomainModel
import com.vinicius.pokeapp.pokemondetail.domain.repository.PokemonDetailRepository
import javax.inject.Inject

class PokemonDetailRepositoryImpl @Inject constructor(
    private val localDataSource: PokemonDetailLocalDataSource,
    private val remoteDataSource: PokemonDetailRemoteDataSource
) : PokemonDetailRepository {

    override suspend fun getPokemonById(id: Int): Result<PokemonDetailDomainModel, ResultError> {
        val result = localDataSource.getPokemonById(id)
        return if (result == null) {
            Result.Error(ResultError.GenericError)
        } else {
            Result.Success(
                result.toPokemonDetailDomainModel()
            )
        }
    }

    override suspend fun getPokemonSpecie(pokemonId: Int): Result<PokemonSpecieDomainModel, ResultError> =
        remoteDataSource.getPokemonSpecie(pokemonId).mapSuccess {
            it.toPokemonSpecieDomainModel()
        }.onSuccess {
            Result.Success(it)
        }.onError {
            Result.Error(ResultError.GenericError)
        }

    override suspend fun getPokemonEvolutionChain(chainId: Int): Result<List<PokemonEvolutionDomainModel>, ResultError> =
        remoteDataSource.getPokemonEvolutionChain(chainId).mapSuccess {
            it.toPokemonEvolutionDomainModel()
        }.onSuccess {
            Result.Success(it)
        }.onSuccess {
            Result.Error(ResultError.GenericError)
        }
}