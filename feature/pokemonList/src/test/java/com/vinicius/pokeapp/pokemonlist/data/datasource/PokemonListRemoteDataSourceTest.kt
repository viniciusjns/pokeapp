package com.vinicius.pokeapp.pokemonlist.data.datasource

import com.vinicius.pokeapp.pokemonlist.data.mapper.PokemonResponseToPokemonListDataMapper
import com.vinicius.pokeapp.service.response.PokemonResponse
import com.vinicius.pokeapp.core.util.Result
import com.vinicius.pokeapp.core.util.ResultError
import com.vinicius.pokeapp.service.service.PokeappService
import io.mockk.*
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class PokemonListRemoteDataSourceTest {

    private val pokeappService: PokeappService = mockk()
    private val pokemonListDataMapper: PokemonResponseToPokemonListDataMapper = mockk()

    private val pokemonListDataSource = PokemonListRemoteDataSourceImpl(
        pokeappService,
        pokemonListDataMapper
    )

    @Test
    fun getPokemons_withSuccess_returnsList() = runBlocking {
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

        val result = pokemonListDataSource.getPokemons()

        assertTrue(result is Result.Success)
        assertEquals(2, result.value.size)
    }

    @Test
    fun getPokemons_withSuccess_returnsEmptyList() = runBlocking {
        prepareScenario()

        val result = pokemonListDataSource.getPokemons()

        assertTrue(result is Result.Success)
        assertTrue(result.value.isEmpty())
    }

    @Test
    fun getPokemons_withError_returnsGenericError() = runBlocking {
        prepareScenario(exception = Exception())

        val result = pokemonListDataSource.getPokemons()

        assertTrue(result is Result.Error)
        assertEquals(ResultError.GenericError, result.value)
    }

    private fun prepareScenario(
        pokemonList: List<PokemonResponse> = emptyList(),
        exception: Exception? = null
    ) {
        if (exception != null) {
            coEvery { pokeappService.fetchPokemons() } throws exception
        } else {
            coEvery { pokeappService.fetchPokemons() } returns pokemonList
        }
        every { pokemonListDataMapper.mapFrom(any()) } returns mockk()
    }
}