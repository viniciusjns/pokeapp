package com.vinicius.pokeapp.pokemondetail.domain.useCase

import com.vinicius.pokeapp.core.util.Result
import com.vinicius.pokeapp.core.util.ResultError
import com.vinicius.pokeapp.pokemondetail.domain.model.PokemonDetailDomainModel

interface GetPokemonByIdUseCase {
    suspend operator fun invoke(id: Int): Result<PokemonDetailDomainModel, ResultError>
}