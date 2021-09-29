package com.vinicius.pokeapp.pokemondetail.domain.useCase

import com.vinicius.pokeapp.service.response.Result
import com.vinicius.pokeapp.pokemondetail.domain.model.PokemonDetailDomainModel

interface PokemonDetailUseCase {
    suspend fun getPokemonById(id: Int): Result<PokemonDetailDomainModel, String>
}