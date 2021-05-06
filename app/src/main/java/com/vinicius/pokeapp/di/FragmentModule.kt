package com.vinicius.pokeapp.di

import com.vinicius.pokeapp.pokemonlist.view.PokemonListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun bindPokemonListFragment(): PokemonListFragment
}