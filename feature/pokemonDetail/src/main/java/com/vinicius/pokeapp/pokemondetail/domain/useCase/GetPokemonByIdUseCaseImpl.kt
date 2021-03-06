package com.vinicius.pokeapp.pokemondetail.domain.useCase

import com.vinicius.pokeapp.core.util.Result
import com.vinicius.pokeapp.core.util.ResultError
import com.vinicius.pokeapp.pokemondetail.domain.repository.PokemonDetailRepository
import com.vinicius.pokeapp.pokemondetail.domain.model.*
import javax.inject.Inject

class GetPokemonByIdUseCaseImpl @Inject constructor(
    private val pokemonDetailRepository: PokemonDetailRepository,
) : GetPokemonByIdUseCase {

    override suspend operator fun invoke(id: Int): Result<PokemonDetailDomainModel, ResultError> =
        pokemonDetailRepository.getPokemonById(id)
            .mapError { ResultError.GenericError }
}