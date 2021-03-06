package com.vinicius.pokeapp.pokemondetail.di

import androidx.lifecycle.ViewModel
import com.vinicius.pokeapp.core.di.ViewModelKey
import com.vinicius.pokeapp.pokemondetail.data.datasource.PokemonDetailLocalDataSource
import com.vinicius.pokeapp.pokemondetail.data.datasource.PokemonDetailLocalDataSourceImpl
import com.vinicius.pokeapp.pokemondetail.data.datasource.PokemonDetailRemoteDataSource
import com.vinicius.pokeapp.pokemondetail.data.datasource.PokemonDetailRemoteDataSourceImpl
import com.vinicius.pokeapp.pokemondetail.domain.repository.PokemonDetailRepository
import com.vinicius.pokeapp.pokemondetail.data.repository.PokemonDetailRepositoryImpl
import com.vinicius.pokeapp.pokemondetail.data.service.PokeappEvolutionService
import com.vinicius.pokeapp.pokemondetail.domain.useCase.*
import com.vinicius.pokeapp.pokemondetail.presentation.view.*
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import retrofit2.Retrofit

@Module(
    includes = [
        PokemonDetailDataModule::class,
        PokemonDetailDomainModule::class,
        PokemonDetailPresentationModule::class,
        PokemonDetailServiceModule::class
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
    fun bindPokemonDetailRemoteDataSource(
        pokemonDetailRemoteDataSource: PokemonDetailRemoteDataSourceImpl
    ): PokemonDetailRemoteDataSource

    @[Binds Reusable]
    fun bindPokemonDetailRepository(
        pokemonDetailRepository: PokemonDetailRepositoryImpl
    ): PokemonDetailRepository
}

@Module
interface PokemonDetailDomainModule {

    @[Binds Reusable]
    fun bindPokemonDetailUseCase(
        pokemonDetailUseCase: GetPokemonByIdUseCaseImpl
    ): GetPokemonByIdUseCase

    @[Binds Reusable]
    fun bindPokemonSpecieUseCase(
        pokemonSpecieUseCase: GetPokemonSpecieUseCaseImpl
    ): GetPokemonSpecieUseCase

    @[Binds Reusable]
    fun bindPokemonEvolutionChainUseCase(
        pokemonEvolutionChainUseCase: GetPokemonEvolutionChainUseCaseImpl
    ): GetPokemonEvolutionChainUseCase
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

    @[Binds IntoMap ViewModelKey(PokemonEvolutionViewModel::class)]
    fun bindPokemonEvolutionViewModel(
        pokemonEvolutionViewModel: PokemonEvolutionViewModel
    ): ViewModel

}

@Module
object PokemonDetailServiceModule {

    @[Provides Reusable]
    internal fun providePokeappEvolutionService(retrofit: Retrofit): PokeappEvolutionService {
        return retrofit.create(PokeappEvolutionService::class.java)
    }

}