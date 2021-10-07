package com.vinicius.pokeapp.pokemonlist.data.datasource

import com.vinicius.pokeapp.pokemonlist.data.mapper.PokemonListDataMapper
import com.vinicius.pokeapp.service.response.PokemonResponse
import com.vinicius.pokeapp.core.util.Result
import com.vinicius.pokeapp.service.service.PokeappService
import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class PokemonListRemoteDataSourceTest {

    private val pokeappService: PokeappService = mockk()
    private val pokemonListDataMapper: PokemonListDataMapper = mockk()

    private val pokemonListDataSource = PokemonListRemoteDataSourceImpl(
        pokeappService,
        pokemonListDataMapper
    )

    @Test
    fun fetchPokemons_withSuccess_returnsList() = runBlocking {
        val pokemonList = listOf(
            PokemonResponse(
                id = 1,
                name = "Bulbasaur",
                types = emptyList(),
                imageUrl = "",
                description = "",
                species = "",
                height = 10.0,
                weight = 50.0,
                training = null,
                breedings = null,
                baseStats = null,
                typeDefenses = null
            ),
            PokemonResponse(
                id = 2,
                name = "Charmander",
                types = emptyList(),
                imageUrl = "",
                description = "",
                species = "",
                height = 10.0,
                weight = 50.0,
                training = null,
                breedings = null,
                baseStats = null,
                typeDefenses = null
            )
        )
        prepareScenario(pokemonList)

        val result = pokemonListDataSource.fetchPokemons()

        assertTrue(result is Result.Success)
        assertEquals(2, result.value.size)
    }

    @Test
    fun fetchPokemons_withSuccess_returnsEmptyList() = runBlocking {
        prepareScenario()

        val result = pokemonListDataSource.fetchPokemons()

        assertTrue(result is Result.Success)
        assertTrue(result.value.isEmpty())
    }

    @Test
    fun fetchPokemons_withError_returnsNothing() = runBlocking {
//        prepareScenario()
//
//        val result = pokemonListDataSource.fetchPokemons()
//
//        assertTrue(result is Result.Error)
//        assertEquals("", result.value)
    }

    private fun prepareScenario(
        pokemonList: List<PokemonResponse> = emptyList(),
    ) {
        coEvery { pokeappService.fetchPokemons() } returns pokemonList
        every { pokemonListDataMapper.mapFrom(any()) } returns mockk()
    }
}