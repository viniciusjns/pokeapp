package com.vinicius.pokeapp.pokemonlist.data.datasource

import com.vinicius.pokeapp.pokemonlist.data.model.PokemonListDataModel
import com.vinicius.pokeapp.service.response.ResultWrapper

interface PokemonListLocalDataSource {

    suspend fun getPokemons(): ResultWrapper<List<PokemonListDataModel>>
}