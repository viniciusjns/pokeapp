package com.vinicius.pokeapp.pokemonlist.domain.repository

import com.vinicius.pokeapp.pokemonlist.data.model.PokemonListDataModel
import com.vinicius.pokeapp.service.response.ResultWrapper

interface PokemonListRepository {

    suspend fun getPokemons(): ResultWrapper<List<PokemonListDataModel>>
}