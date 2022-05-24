package com.vinicius.pokeapp.pokemondetail.data.repository

import com.vinicius.pokeapp.core.util.Result
import com.vinicius.pokeapp.core.util.ResultError
import com.vinicius.pokeapp.pokemondetail.data.datasource.PokemonDetailLocalDataSource
import com.vinicius.pokeapp.pokemondetail.data.mapper.toPokemonDetailDomainModel
import com.vinicius.pokeapp.pokemondetail.domain.model.PokemonDetailDomainModel
import com.vinicius.pokeapp.pokemondetail.domain.repository.PokemonDetailRepository
import javax.inject.Inject

class PokemonDetailRepositoryImpl @Inject constructor(
    private val localDataSource: PokemonDetailLocalDataSource,
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
}