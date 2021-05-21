package com.vinicius.pokeapp.pokemondetail.di

import com.vinicius.pokeapp.pokemondetail.presentation.PokemonDetailFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(
    includes = [
        PokemonDetailFragmentModule::class,
//        PokemonListRepositoryModule::class,
//        PokemonListUseCaseModule::class,
//        PokemonListViewModelModule::class,
    ]
)
object PokemonDetailModule

@Module
interface PokemonDetailFragmentModule {
    @ContributesAndroidInjector
    fun bindPokemonDetailFragment(): PokemonDetailFragment
}

//@Module
//interface PokemonListRepositoryModule {
//
//    @[Binds Reusable]
//    fun bindPokemonRepository(pokemonRepository: PokemonListRepositoryImpl): PokemonListRepository
//}
//
//@Module
//interface PokemonListUseCaseModule {
//
//    @[Binds Reusable]
//    fun bindPokemonUseCase(pokemonUseCase: PokemonListUseCaseImpl): PokemonListUseCase
//}
//
//@Module
//interface PokemonListViewModelModule {
//
//    @[Binds IntoMap ViewModelKey(PokemonListViewModel::class)]
//    fun bindPokemonViewModel(pokemonListViewModel: PokemonListViewModel): ViewModel
//
//    @[Binds Reusable]
//    fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory
//}