package com.vinicius.pokeapp.pokemondetail.domain.useCase

import com.vinicius.pokeapp.core.util.Result
import com.vinicius.pokeapp.core.util.ResultError
import com.vinicius.pokeapp.pokemondetail.domain.model.PokemonSpecieDomainModel
import com.vinicius.pokeapp.pokemondetail.domain.repository.PokemonDetailRepository

class GetPokemonSpecieUseCaseImpl(
    private val repository: PokemonDetailRepository
) : GetPokemonSpecieUseCase {

    override suspend operator fun invoke(pokemonId: Int): Result<PokemonSpecieDomainModel, ResultError> =
        repository.getPokemonSpecie(pokemonId)
}