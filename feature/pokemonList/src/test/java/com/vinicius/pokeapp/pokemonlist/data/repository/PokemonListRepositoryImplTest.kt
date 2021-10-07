package com.vinicius.pokeapp.pokemonlist.data.repository

import com.vinicius.pokeapp.pokemonlist.data.datasource.PokemonListLocalDataSource
import com.vinicius.pokeapp.pokemonlist.data.datasource.PokemonListRemoteDataSource
import com.vinicius.pokeapp.pokemonlist.data.model.PokemonListDataModel
import com.vinicius.pokeapp.core.util.Result
import com.vinicius.pokeapp.core.util.ResultError
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
    fun fetchPokemons_withLocalDataSourceSuccess_returnLocalDataSourceSuccess() = runBlocking {
        val localDataSourceList = listOf(
            PokemonListDataModel(
                id = "1",
                name = "Bulbasaur",
                types = emptyList(),
                imageUrl = ""
            )
        )
        prepareScenario(localDataSourceResult = Result.Success(localDataSourceList))

        val result = pokemonListRepository.getPokemons()

        assertTrue(result is Result.Success &&
            result.value.size == 1)
    }

    @Test
    fun fetchPokemons_withLocalDataSourceError_returnRemoteDataSourceSuccess() = runBlocking {
        val remoteDataSourceList = listOf(
            PokemonListDataModel(
                id = "1",
                name = "Bulbasaur",
                types = emptyList(),
                imageUrl = ""
            )
        )
        prepareScenario(
            localDataSourceResult = Result.Error(ResultError.GenericError),
            remoteDataSourceResult = Result.Success(remoteDataSourceList)
        )

        val result = pokemonListRepository.getPokemons()

        assertTrue(result is Result.Success &&
                result.value.size == 1)
    }

    private fun prepareScenario(
        localDataSourceResult: Result<List<PokemonListDataModel>, ResultError> = Result.Success(emptyList()),
        remoteDataSourceResult: Result<List<PokemonListDataModel>, ResultError> = Result.Success(emptyList()),
    ) {
        coEvery { localDataSource.getPokemons() } returns localDataSourceResult
        coEvery { remoteDataSource.getPokemons() } returns remoteDataSourceResult
    }
}