package com.vinicius.pokeapp.pokemonlist.presentation.view

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.vinicius.pokeapp.pokemonlist.domain.model.PokemonListDomainModel
import com.vinicius.pokeapp.pokemonlist.domain.useCase.GetPokemonsUseCase
import com.vinicius.pokeapp.pokemonlist.presentation.mapper.PokemonListPresentationMapper
import com.vinicius.pokeapp.core.util.Result
import com.vinicius.pokeapp.pokemonlist.domain.model.PokemonListDomainErrorModel
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals

@ExperimentalCoroutinesApi
class PokemonListViewModelTest {

    @get:Rule
    var instantTask = InstantTaskExecutorRule()

    private val pokemonListUseCase: GetPokemonsUseCase = mockk()
    private val pokemonListPresentationMapper: PokemonListPresentationMapper = mockk()

    private val viewModel = PokemonListViewModel(
        pokemonListUseCase, pokemonListPresentationMapper
    )

    @Test
    fun getPokemons_withEmptyList_returnSuccess() = runBlocking {
        prepareScenario()

        viewModel.dispatchViewAction(PokemonListViewAction.GetPokemons)

        val actual = viewModel.viewState.pokemonLiveData.value

        assertEquals(0, actual?.size)
        assertEquals(PokemonListViewState.State.SUCCESS, viewModel.viewState.state.value)
    }

    @Test
    fun fetchPokemons_withFullList_returnSuccess() = runBlocking {
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

        viewModel.dispatchViewAction(PokemonListViewAction.GetPokemons)

        assertEquals(1, viewModel.viewState.pokemonLiveData.value?.size)
        assertEquals(PokemonListViewState.State.SUCCESS, viewModel.viewState.state.value)
    }

    @Test
    fun fetchPokemons_withError_returnGenericError() = runBlocking {
        prepareScenario(
            pokemonListResult = Result.Error(PokemonListDomainErrorModel.GenericError)
        )

        viewModel.dispatchViewAction(PokemonListViewAction.GetPokemons)

        assertEquals(0, viewModel.viewState.pokemonLiveData.value?.size)
        assertEquals(PokemonListViewState.State.ERROR, viewModel.viewState.state.value)
    }

    private fun prepareScenario(
        pokemonListResult: Result<List<PokemonListDomainModel>, PokemonListDomainErrorModel> = Result.Success(emptyList())
    ) {
        coEvery { pokemonListUseCase() } returns pokemonListResult
        every { pokemonListPresentationMapper.mapFrom(any()) } returns mockk()
    }

}