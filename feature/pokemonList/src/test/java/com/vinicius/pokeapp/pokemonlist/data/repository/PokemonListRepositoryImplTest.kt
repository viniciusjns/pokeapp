package com.vinicius.pokeapp.pokemonlist.data.repository

import com.vinicius.pokeapp.pokemonlist.data.datasource.PokemonListLocalDataSource
import com.vinicius.pokeapp.pokemonlist.data.datasource.PokemonListRemoteDataSource
import com.vinicius.pokeapp.pokemonlist.data.model.PokemonListDataModel
import com.vinicius.pokeapp.service.response.Result
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class PokemonListRepositoryImplTest {

    private val remoteDataSource: PokemonListRemoteDataSource = mockk()
    private val localDataSource: PokemonListLocalDataSource = mockk()

    private val pokemonListRepository = PokemonListRepositoryImpl(
        remoteDataSource, localDataSource
    )

    @Test
    fun fetchPokemons_withLocalDataSourceFull_returnSuccess() = runBlocking {
        val localDataSourceList = listOf(
            PokemonListDataModel(
                id = "1",
                name = "Bulbasaur",
                types = emptyList(),
                imageUrl = ""
            )
        )
        prepareScenario(localDataSourceResult = Result.Success(localDataSourceList))

        val result = pokemonListRepository.fetchPokemons()

        assertTrue(result is Result.Success)
        assertEquals(1, result.handleResult()?.size)
    }

    @Test
    fun fetchPokemons_withLocalDataSourceEmptyAndRemoteDataSourceFull_returnSuccess() = runBlocking {
        val localDataSourceList = emptyList<PokemonListDataModel>()
        val remoteDataSourceList = listOf(
            PokemonListDataModel(
                id = "1",
                name = "Bulbasaur",
                types = emptyList(),
                imageUrl = ""
            )
        )
        prepareScenario(
            localDataSourceResult = Result.Success(localDataSourceList),
            remoteDataSourceResult = Result.Success(remoteDataSourceList)
        )

        val result = pokemonListRepository.fetchPokemons()

        assertTrue(result is Result.Success)
        assertEquals(1, result.handleResult()?.size)
    }

    @Test
    fun fetchPokemons_withLocalDataSourceEmptyAndRemoteDataSourceEmpty_returnSuccess() = runBlocking {
        val localDataSourceList = emptyList<PokemonListDataModel>()
        val remoteDataSourceList = emptyList<PokemonListDataModel>()
        prepareScenario(
            localDataSourceResult = Result.Success(localDataSourceList),
            remoteDataSourceResult = Result.Success(remoteDataSourceList)
        )

        val result = pokemonListRepository.fetchPokemons()

        assertTrue(result is Result.Success)
        assertEquals(0, result.handleResult()?.size)
    }

    private fun prepareScenario(
        localDataSourceResult: Result<List<PokemonListDataModel>, String> = Result.Success(emptyList()),
        remoteDataSourceResult: Result<List<PokemonListDataModel>, String> = Result.Success(emptyList()),
    ) {
        coEvery { localDataSource.fetchPokemons() } returns localDataSourceResult
        coEvery { remoteDataSource.fetchPokemons() } returns remoteDataSourceResult
    }
}