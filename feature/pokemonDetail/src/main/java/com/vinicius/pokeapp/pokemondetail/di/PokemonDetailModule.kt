package com.vinicius.pokeapp.pokemondetail.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vinicius.pokeapp.core.di.ViewModelKey
import com.vinicius.pokeapp.core.di.ViewModelProviderFactory
import com.vinicius.pokeapp.pokemondetail.data.datasource.PokemonDetailLocalDataSource
import com.vinicius.pokeapp.pokemondetail.data.datasource.PokemonDetailLocalDataSourceImpl
import com.vinicius.pokeapp.pokemondetail.data.repository.PokemonDetailRepository
import com.vinicius.pokeapp.pokemondetail.data.repository.PokemonDetailRepositoryImpl
import com.vinicius.pokeapp.pokemondetail.domain.PokemonDetailUseCase
import com.vinicius.pokeapp.pokemondetail.domain.PokemonDetailUseCaseImpl
import com.vinicius.pokeapp.pokemondetail.presentation.PokemonAboutFragment
import com.vinicius.pokeapp.pokemondetail.presentation.PokemonDetailFragment
import com.vinicius.pokeapp.pokemondetail.presentation.PokemonDetailViewModel
import dagger.Binds
import dagger.Module
import dagger.Reusable
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module(
    includes = [
        PokemonDetailFragmentModule::class,
        PokemonDetailDataSource::class,
        PokemonDetailRepositoryModule::class,
        PokemonDetailUseCaseModule::class,
        PokemonDetailViewModelModule::class,
    ]
)
object PokemonDetailModule

@Module
interface PokemonDetailFragmentModule {
    @ContributesAndroidInjector
    fun bindPokemonDetailFragment(): PokemonDetailFragment

    @ContributesAndroidInjector
    fun bindPokemonAboutFragment(): PokemonAboutFragment
}

@Module
interface PokemonDetailDataSource {

    @[Binds Reusable]
    fun bindPokemonDetailLocalDataSource(
        pokemonDetailLocalDataSource: PokemonDetailLocalDataSourceImpl
    ): PokemonDetailLocalDataSource
}

@Module
interface PokemonDetailRepositoryModule {

    @[Binds Reusable]
    fun bindPokemonDetailRepository(
        pokemonDetailRepository: PokemonDetailRepositoryImpl
    ): PokemonDetailRepository
}

@Module
interface PokemonDetailUseCaseModule {

    @[Binds Reusable]
    fun bindPokemonDetailUseCase(
        pokemonDetailUseCase: PokemonDetailUseCaseImpl
    ): PokemonDetailUseCase
}

@Module
interface PokemonDetailViewModelModule {

    @[Binds IntoMap ViewModelKey(PokemonDetailViewModel::class)]
    fun bindPokemonDetailViewModel(
        pokemonDetailViewModel: PokemonDetailViewModel
    ): ViewModel

//    @[Binds Reusable]
//    fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory
}