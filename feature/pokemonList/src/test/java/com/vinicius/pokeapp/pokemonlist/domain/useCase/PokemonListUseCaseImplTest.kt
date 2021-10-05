package com.vinicius.pokeapp.pokemonlist.domain.useCase

import com.vinicius.pokeapp.pokemonlist.data.model.PokemonListDataModel
import com.vinicius.pokeapp.pokemonlist.domain.repository.PokemonListRepository
import com.vinicius.pokeapp.pokemonlist.domain.mapper.PokemonListDomainMapper
import com.vinicius.pokeapp.service.response.Result
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class PokemonListUseCaseImplTest {
    private val pokemonListRepository: PokemonListRepository = mockk()
    private val pokemonListDomainMapper: PokemonListDomainMapper = mockk()

    private val pokemonListUseCase = PokemonListUseCaseImpl(
        pokemonListRepository, pokemonListDomainMapper
    )

    @Test
    fun fetchPokemons_withListFull_returnSuccess() = runBlocking {
        val pokemonList = listOf(
            PokemonListDataModel(
                id = "1",
                name = "Bulbasaur",
                types = emptyList(),
                imageUrl = ""
            )
        )
        prepareScenario(Result.Success(pokemonList))

        val result = pokemonListUseCase.fetchPokemons()

        assertTrue(result is Result.Success)
        assertEquals(1, result.handleResult()?.size)
    }

    private fun prepareScenario(
        pokemonListResult: Result<List<PokemonListDataModel>, String> = Result.Success(emptyList())
    ) {
        coEvery { pokemonListRepository.fetchPokemons() } returns pokemonListResult
        every { pokemonListDomainMapper.mapFrom(any()) } returns mockk()
    }
}