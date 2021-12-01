package com.vinicius.pokeapp.database.di

import android.app.Application
import com.vinicius.pokeapp.database.PokemonDatabase
import com.vinicius.pokeapp.database.dao.PokemonDao
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
object DatabaseModule {

    @Provides
    fun providePokemonDatabase(application: Application): PokemonDatabase =
        PokemonDatabase.createDatabase(application.applicationContext)

    @Provides
    @Reusable
    fun providePokemonDao(database: PokemonDatabase): PokemonDao = database.pokemonDao()
}