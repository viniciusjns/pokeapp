package com.vinicius.pokeapp.pokemonlist.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vinicius.pokeapp.core.di.ViewModelKey
import com.vinicius.pokeapp.core.di.ViewModelProviderFactory
import com.vinicius.pokeapp.pokemonlist.data.PokemonListRepository
import com.vinicius.pokeapp.pokemonlist.data.PokemonListRepositoryImpl
import com.vinicius.pokeapp.pokemonlist.domain.PokemonListUseCase
import com.vinicius.pokeapp.pokemonlist.domain.PokemonListUseCaseImpl
import com.vinicius.pokeapp.pokemonlist.presentation.PokemonListFragment
import com.vinicius.pokeapp.pokemonlist.presentation.PokemonListViewModel
import dagger.Binds
import dagger.Module
import dagger.Reusable
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module(
    includes = [
        PokemonListFragmentModule::class,
        PokemonListRepositoryModule::class,
        PokemonListUseCaseModule::class,
        PokemonListViewModelModule::class,
    ]
)
object PokemonListModule

@Module
interface PokemonListFragmentModule {
    @ContributesAndroidInjector
    fun bindPokemonListFragment(): PokemonListFragment
}

@Module
interface PokemonListRepositoryModule {

    @[Binds Reusable]
    fun bindPokemonRepository(pokemonRepository: PokemonListRepositoryImpl): PokemonListRepository
}

@Module
interface PokemonListUseCaseModule {

    @[Binds Reusable]
    fun bindPokemonUseCase(pokemonUseCase: PokemonListUseCaseImpl): PokemonListUseCase
}

@Module
interface PokemonListViewModelModule {

    @[Binds IntoMap ViewModelKey(PokemonListViewModel::class)]
    fun bindPokemonViewModel(pokemonListViewModel: PokemonListViewModel): ViewModel

    @[Binds Reusable]
    fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory
}