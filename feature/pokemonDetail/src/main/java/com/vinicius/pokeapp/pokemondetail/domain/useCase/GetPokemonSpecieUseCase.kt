package com.vinicius.pokeapp.pokemondetail.domain.useCase

import com.vinicius.pokeapp.core.util.Result
import com.vinicius.pokeapp.core.util.ResultError
import com.vinicius.pokeapp.pokemondetail.domain.model.PokemonSpecieDomainModel

interface GetPokemonSpecieUseCase {
    suspend operator fun invoke(pokemonId: Int): Result<PokemonSpecieDomainModel, ResultError>
}