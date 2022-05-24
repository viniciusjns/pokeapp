package com.vinicius.pokeapp.pokemonlist.domain.useCase

import com.vinicius.pokeapp.pokemonlist.domain.repository.PokemonListRepository
import com.vinicius.pokeapp.pokemonlist.domain.model.PokemonListDomainErrorModel
import com.vinicius.pokeapp.pokemonlist.domain.model.PokemonListDomainModel
import com.vinicius.pokeapp.core.util.Result
import com.vinicius.pokeapp.core.util.ResultError
import javax.inject.Inject

class GetPokemonsUseCaseImpl @Inject constructor(
    private val pokemonListRepository: PokemonListRepository,
) : GetPokemonsUseCase {

    override suspend fun invoke(): Result<List<PokemonListDomainModel>, PokemonListDomainErrorModel> {
        return pokemonListRepository.getPokemons()
            .mapError(::mapDataError)
    }

    private fun mapDataError(
        error: ResultError
    ): PokemonListDomainErrorModel = when(error) {
        ResultError.GenericError -> PokemonListDomainErrorModel.GenericError
        is ResultError.NetworkError -> PokemonListDomainErrorModel.NetworkError
    }
}