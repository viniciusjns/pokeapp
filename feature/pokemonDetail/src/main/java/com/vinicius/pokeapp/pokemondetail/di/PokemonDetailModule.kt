package com.vinicius.pokeapp.pokemondetail.di

import androidx.lifecycle.ViewModel
import com.vinicius.pokeapp.core.di.ViewModelKey
import com.vinicius.pokeapp.pokemondetail.data.datasource.PokemonDetailLocalDataSource
import com.vinicius.pokeapp.pokemondetail.data.datasource.PokemonDetailLocalDataSourceImpl
import com.vinicius.pokeapp.pokemondetail.data.repository.PokemonDetailRepository
import com.vinicius.pokeapp.pokemondetail.data.repository.PokemonDetailRepositoryImpl
import com.vinicius.pokeapp.pokemondetail.domain.useCase.PokemonDetailUseCase
import com.vinicius.pokeapp.pokemondetail.domain.useCase.PokemonDetailUseCaseImpl
import com.vinicius.pokeapp.pokemondetail.presentation.view.*
import dagger.Binds
import dagger.Module
import dagger.Reusable
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module(
    includes = [
        PokemonDetailDataModule::class,
        PokemonDetailDomainModule::class,
        PokemonDetailPresentationModule::class,
    ]
)
object PokemonDetailModule

@Module
interface PokemonDetailDataModule{

    @[Binds Reusable]
    fun bindPokemonDetailLocalDataSource(
        pokemonDetailLocalDataSource: PokemonDetailLocalDataSourceImpl
    ): PokemonDetailLocalDataSource

    @[Binds Reusable]
    fun bindPokemonDetailRepository(
        pokemonDetailRepository: PokemonDetailRepositoryImpl
    ): PokemonDetailRepository
}

@Module
interface PokemonDetailDomainModule {

    @[Binds Reusable]
    fun bindPokemonDetailUseCase(
        pokemonDetailUseCase: PokemonDetailUseCaseImpl
    ): PokemonDetailUseCase
}

@Module
interface PokemonDetailPresentationModule {

    @ContributesAndroidInjector
    fun contributesPokemonDetailFragment(): PokemonDetailFragment

    @ContributesAndroidInjector
    fun contributesPokemonAboutFragment(): PokemonAboutFragment

    @ContributesAndroidInjector
    fun contributesPokemonStatsFragment(): PokemonStatsFragment

    @ContributesAndroidInjector
    fun contributesPokemonEvolutionFragment(): PokemonEvolutionFragment

    @[Binds IntoMap ViewModelKey(PokemonDetailViewModel::class)]
    fun bindPokemonDetailViewModel(
        pokemonDetailViewModel: PokemonDetailViewModel
    ): ViewModel

}