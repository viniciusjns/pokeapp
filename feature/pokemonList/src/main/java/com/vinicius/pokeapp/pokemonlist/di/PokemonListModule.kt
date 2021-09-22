package com.vinicius.pokeapp.pokemonlist.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vinicius.pokeapp.core.di.ViewModelKey
import com.vinicius.pokeapp.core.di.ViewModelProviderFactory
import com.vinicius.pokeapp.pokemonlist.data.datasource.PokemonListLocalDataSource
import com.vinicius.pokeapp.pokemonlist.data.datasource.PokemonListLocalDataSourceImpl
import com.vinicius.pokeapp.pokemonlist.data.datasource.PokemonListRemoteDataSource
import com.vinicius.pokeapp.pokemonlist.data.datasource.PokemonListRemoteDataSourceImpl
import com.vinicius.pokeapp.pokemonlist.data.repository.PokemonListRepository
import com.vinicius.pokeapp.pokemonlist.data.repository.PokemonListRepositoryImpl
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
        PokemonListDataSource::class,
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
interface PokemonListDataSource {

    @[Binds Reusable]
    fun bindPokemonListRemoteDataSource(
        pokemonListRemoteDataSource: PokemonListRemoteDataSourceImpl
    ): PokemonListRemoteDataSource

    @[Binds Reusable]
    fun bindPokemonListLocalDataSource(
        pokemonListLocalDataSource: PokemonListLocalDataSourceImpl
    ): PokemonListLocalDataSource
}

@Module
interface PokemonListRepositoryModule {

    @[Binds Reusable]
    fun bindPokemonListRepository(
        pokemonListRepository: PokemonListRepositoryImpl
    ): PokemonListRepository
}

@Module
interface PokemonListUseCaseModule {

    @[Binds Reusable]
    fun bindPokemonListUseCase(
        pokemonListUseCase: PokemonListUseCaseImpl
    ): PokemonListUseCase
}

@Module
interface PokemonListViewModelModule {

    @[Binds IntoMap ViewModelKey(PokemonListViewModel::class)]
    fun bindPokemonListViewModel(
        pokemonListViewModel: PokemonListViewModel
    ): ViewModel

}