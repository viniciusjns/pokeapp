package com.vinicius.pokeapp.pokemondetail.data.repository

import com.vinicius.pokeapp.service.response.Result
import com.vinicius.pokeapp.pokemondetail.data.datasource.PokemonDetailLocalDataSource
import com.vinicius.pokeapp.pokemondetail.data.model.PokemonDetailDataModel
import javax.inject.Inject

class PokemonDetailRepositoryImpl @Inject constructor(
    private val localDataSource: PokemonDetailLocalDataSource,
) : PokemonDetailRepository {

    override suspend fun getPokemonById(id: Int): Result<PokemonDetailDataModel, String> =
        localDataSource.getPokemonById(id)
}