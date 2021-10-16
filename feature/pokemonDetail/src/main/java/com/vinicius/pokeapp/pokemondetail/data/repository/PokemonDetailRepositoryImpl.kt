package com.vinicius.pokeapp.pokemondetail.data.repository

import com.vinicius.pokeapp.core.util.Result
import com.vinicius.pokeapp.core.util.ResultError
import com.vinicius.pokeapp.pokemondetail.data.datasource.PokemonDetailLocalDataSource
import com.vinicius.pokeapp.pokemondetail.data.mapper.PokemonDetailDataMapper
import com.vinicius.pokeapp.pokemondetail.data.model.PokemonDetailDataModel
import com.vinicius.pokeapp.pokemondetail.domain.repository.PokemonDetailRepository
import javax.inject.Inject

class PokemonDetailRepositoryImpl @Inject constructor(
    private val localDataSource: PokemonDetailLocalDataSource,
    private val pokemonDetailDataMapper: PokemonDetailDataMapper
) : PokemonDetailRepository {

    override suspend fun getPokemonById(id: Int): Result<PokemonDetailDataModel, ResultError> {
        val result = localDataSource.getPokemonById(id)
        return if (result == null) {
            Result.Error(ResultError.GenericError)
        } else {
            Result.Success(
                pokemonDetailDataMapper.mapFrom(result)
            )
        }
    }
}