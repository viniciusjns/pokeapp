package com.vinicius.pokeapp.pokemonlist.domain.useCase

import com.vinicius.pokeapp.pokemonlist.domain.model.PokemonListDomainModel
import com.vinicius.pokeapp.service.response.ResultWrapper

interface PokemonListUseCase {
    suspend fun getPokemons(): ResultWrapper<List<PokemonListDomainModel>>
}