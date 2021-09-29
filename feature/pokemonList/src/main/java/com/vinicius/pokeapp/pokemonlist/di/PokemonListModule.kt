package com.vinicius.pokeapp.pokemonlist.di

import androidx.lifecycle.ViewModel
import com.vinicius.pokeapp.core.di.ViewModelKey
import com.vinicius.pokeapp.pokemonlist.data.datasource.PokemonListLocalDataSource
import com.vinicius.pokeapp.pokemonlist.data.datasource.PokemonListLocalDataSourceImpl
import com.vinicius.pokeapp.pokemonlist.data.datasource.PokemonListRemoteDataSource
import com.vinicius.pokeapp.pokemonlist.data.datasource.PokemonListRemoteDataSourceImpl
import com.vinicius.pokeapp.pokemonlist.data.repository.PokemonListRepository
import com.vinicius.pokeapp.pokemonlist.data.repository.PokemonListRepositoryImpl
import com.vinicius.pokeapp.pokemonlist.domain.useCase.PokemonListUseCase
import com.vinicius.pokeapp.pokemonlist.domain.useCase.PokemonListUseCaseImpl
import com.vinicius.pokeapp.pokemonlist.presentation.view.PokemonListFragment
import com.vinicius.pokeapp.pokemonlist.presentation.view.PokemonListViewModel
import dagger.Binds
import dagger.Module
import dagger.Reusable
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module(
    includes = [
        PokemonListDataModule::class,
        PokemonListDomainModule::class,
        PokemonListPresentationModule::class,
    ]
)
object PokemonListModule

@Module
interface PokemonListDataModule {

    @[Binds Reusable]
    fun bindPokemonListRemoteDataSource(
        pokemonListRemoteDataSource: PokemonListRemoteDataSourceImpl
    ): PokemonListRemoteDataSource

    @[Binds Reusable]
    fun bindPokemonListLocalDataSource(
        pokemonListLocalDataSource: PokemonListLocalDataSourceImpl
    ): PokemonListLocalDataSource

    @[Binds Reusable]
    fun bindPokemonListRepository(
        pokemonListRepository: PokemonListRepositoryImpl
    ): PokemonListRepository
}

@Module
interface PokemonListDomainModule {

    @[Binds Reusable]
    fun bindPokemonListUseCase(
        pokemonListUseCase: PokemonListUseCaseImpl
    ): PokemonListUseCase
}

@Module
interface PokemonListPresentationModule {

    @ContributesAndroidInjector
    fun bindPokemonListFragment(): PokemonListFragment

    @[Binds IntoMap ViewModelKey(PokemonListViewModel::class)]
    fun bindPokemonListViewModel(
        pokemonListViewModel: PokemonListViewModel
    ): ViewModel

}