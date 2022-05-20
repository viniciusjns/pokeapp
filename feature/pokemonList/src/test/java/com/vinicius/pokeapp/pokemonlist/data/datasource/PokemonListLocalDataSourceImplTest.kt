package com.vinicius.pokeapp.pokemonlist.data.datasource

import com.vinicius.pokeapp.core.util.Result
import com.vinicius.pokeapp.core.util.ResultError
import com.vinicius.pokeapp.pokemonlist.data.mapper.PokemonResponseToPokemonListDataMapper
import com.vinicius.pokeapp.pokemonlist.data.model.PokemonResponse
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test

class PokemonListLocalDataSourceImplTest {

    private val pokemonListDataMapper: PokemonResponseToPokemonListDataMapper = mockk()

    private val pokemonListLocalDataSource = PokemonListLocalDataSourceImpl(
        pokemonListDataMapper
    )

    @Test
    fun getPokemons_withPokemonsInStorage_returnsSuccess() = runBlocking {
        prepareScenario(
            pokemonList = mutableListOf(
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
                )
            )
        )

        val result = pokemonListLocalDataSource.getPokemons()

        assertTrue(result is Result.Success &&
            result.value.size == 1)
    }

    @Test
    fun getPokemons_withNoPokemonInStorage_returnsError() = runBlocking {
        prepareScenario()

        val result = pokemonListLocalDataSource.getPokemons()

        assertTrue(result is Result.Error &&
                result.value == ResultError.GenericError)
    }

    private fun prepareScenario(
        pokemonList: MutableList<PokemonResponse> = mutableListOf(),
    ) {
        PokemonSingleton.pokemonList.addAll(pokemonList)
        every { pokemonListDataMapper.mapFrom(any()) } returns mockk()
    }
}