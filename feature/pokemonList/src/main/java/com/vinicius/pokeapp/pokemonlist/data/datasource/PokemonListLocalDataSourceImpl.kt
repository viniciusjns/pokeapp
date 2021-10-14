package com.vinicius.pokeapp.pokemonlist.data.datasource

import com.vinicius.pokeapp.database.dao.PokemonDao
import com.vinicius.pokeapp.database.entity.PokemonEntity
import javax.inject.Inject

class PokemonListLocalDataSourceImpl @Inject constructor(
    private val pokemonDao: PokemonDao
) : PokemonListLocalDataSource {

    override suspend fun getPokemons(): List<PokemonEntity> =
        pokemonDao.getPokemons()

    override suspend fun savePokemons(pokemons: List<PokemonEntity>) {
        pokemonDao.savePokemons(pokemons)
    }
}