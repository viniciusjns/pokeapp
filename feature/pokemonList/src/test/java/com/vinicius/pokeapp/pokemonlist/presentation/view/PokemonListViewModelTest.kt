package com.vinicius.pokeapp.pokemonlist.presentation.view

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.vinicius.core.MainCoroutineRule
import com.vinicius.pokeapp.pokemonlist.domain.model.PokemonListDomainModel
import com.vinicius.pokeapp.pokemonlist.domain.useCase.PokemonListUseCase
import com.vinicius.pokeapp.pokemonlist.presentation.mapper.PokemonListPresentationMapper
import com.vinicius.pokeapp.service.response.Result
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@ExperimentalCoroutinesApi
class PokemonListViewModelTest {

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @get:Rule
    var instantTask = InstantTaskExecutorRule()

    private val pokemonListUseCase: PokemonListUseCase = mockk()
    private val pokemonListPresentationMapper: PokemonListPresentationMapper = mockk()

    private val viewModel = PokemonListViewModel(
        pokemonListUseCase, pokemonListPresentationMapper
    )

    @Test
    fun fetchPokemons_onSuccess_withEmptyList() = mainCoroutineRule.runBlockingTest {
        prepareScenario()

        viewModel.dispatchViewAction(PokemonListViewAction.FetchPokemons)

        assertTrue(viewModel.viewState.pokemonLiveData.value!!.isEmpty())
        assertEquals(PokemonListViewState.State.EMPTY, viewModel.viewState.state.value)
    }

    @Test
    fun fetchPokemons_onSuccess_withFullList() = mainCoroutineRule.runBlockingTest {
        prepareScenario(
            pokemonListResult = Result.Success(listOf(
                PokemonListDomainModel(
                    id = "1",
                    name = "Bulbasaur",
                    imageUrl = "",
                    types = listOf()
                )
            ))
        )

        viewModel.dispatchViewAction(PokemonListViewAction.FetchPokemons)

        assertEquals(1, viewModel.viewState.pokemonLiveData.value?.size)
        assertEquals(PokemonListViewState.State.SUCCESS, viewModel.viewState.state.value)
    }

    @Test
    fun fetchPokemons_onError_withEmptyList() = mainCoroutineRule.runBlockingTest {
        prepareScenario(
            pokemonListResult = Result.Error("")
        )

        viewModel.dispatchViewAction(PokemonListViewAction.FetchPokemons)

        assertTrue(viewModel.viewState.pokemonLiveData.value!!.isEmpty())
        assertEquals(PokemonListViewState.State.ERROR, viewModel.viewState.state.value)
    }

    private fun prepareScenario(
        pokemonListResult: Result<List<PokemonListDomainModel>, String> = Result.Success(emptyList())
    ) {
        coEvery { pokemonListUseCase.fetchPokemons() } returns pokemonListResult
        every { pokemonListPresentationMapper.mapFrom(any()) } returns mockk()
    }

}