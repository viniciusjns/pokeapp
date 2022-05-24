package com.vinicius.pokeapp.pokemonlist.domain.useCase

import com.vinicius.pokeapp.pokemonlist.domain.repository.PokemonListRepository
import com.vinicius.pokeapp.pokemonlist.domain.mapper.PokemonListDomainMapper
import com.vinicius.pokeapp.core.util.Result
import com.vinicius.pokeapp.core.util.ResultError
import com.vinicius.pokeapp.pokemonlist.domain.model.PokemonListDomainErrorModel
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class PokemonListUseCaseImplTest {
    private val pokemonListRepository: PokemonListRepository = mockk()
    private val pokemonListDomainMapper: PokemonListDomainMapper = mockk()

    private val getPokemonsUseCase = GetPokemonsUseCaseImpl(
        pokemonListRepository, pokemonListDomainMapper
    )

    @Test
    fun getPokemons_withListFull_returnSuccess() = runBlocking {
        val pokemonList = listOf(
            PokemonListDataModel(
                id = "1",
                name = "Bulbasaur",
                types = emptyList(),
                imageUrl = ""
            )
        )
        prepareScenario(Result.Success(pokemonList))

        val result = getPokemonsUseCase()

        assertTrue(result is Result.Success &&
                result.value.size == 1)
    }

    @Test
    fun getPokemons_withEmptyList_returnError() = runBlocking {
        prepareScenario(Result.Error(ResultError.GenericError))

        val result = getPokemonsUseCase()

        assertTrue(result is Result.Error &&
            result.value == PokemonListDomainErrorModel.GenericError)
    }

    private fun prepareScenario(
        pokemonListResult: Result<List<PokemonListDataModel>, ResultError> = Result.Success(emptyList())
    ) {
        coEvery { pokemonListRepository.getPokemons() } returns pokemonListResult
        every { pokemonListDomainMapper.mapFrom(any()) } returns mockk()
    }
}