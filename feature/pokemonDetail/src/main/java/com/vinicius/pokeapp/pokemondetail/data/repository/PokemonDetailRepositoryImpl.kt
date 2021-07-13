package com.vinicius.pokeapp.pokemondetail.data.repository

import com.vinicius.pokeapp.core.data.Result
import com.vinicius.pokeapp.pokemondetail.data.datasource.PokemonDetailLocalDataSource
import com.vinicius.pokeapp.pokemondetail.data.model.PokemonDataModel
import javax.inject.Inject

class PokemonDetailRepositoryImpl @Inject constructor(
    private val localDataSource: PokemonDetailLocalDataSource,
) : PokemonDetailRepository {

    override suspend fun getPokemonById(id: Int): Result<PokemonDataModel, String> =
        localDataSource.getPokemonById(id)
}