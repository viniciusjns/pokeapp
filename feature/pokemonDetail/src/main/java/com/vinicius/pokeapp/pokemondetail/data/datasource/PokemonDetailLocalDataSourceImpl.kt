package com.vinicius.pokeapp.pokemondetail.data.datasource

import com.vinicius.pokeapp.database.dao.PokemonDao
import com.vinicius.pokeapp.database.entity.PokemonEntity
import javax.inject.Inject

class PokemonDetailLocalDataSourceImpl @Inject constructor(
    private val pokemonDao: PokemonDao
) : PokemonDetailLocalDataSource {

    override suspend fun getPokemonById(id: Int): PokemonEntity? =
        pokemonDao.getPokemonById(id)
}