package com.vinicius.pokeapp.di

import android.app.Application
import com.vinicius.pokeapp.PokeappApplication
import com.vinicius.pokeapp.core.di.CoreModule
import com.vinicius.pokeapp.database.di.DatabaseModule
import com.vinicius.pokeapp.pokemondetail.di.PokemonDetailModule
import com.vinicius.pokeapp.pokemonlist.di.PokemonListModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import org.jetbrains.annotations.NotNull
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        ActivityModule::class,
        CoreModule::class,
        PokemonListModule::class,
        PokemonDetailModule::class,
        DatabaseModule::class,
    ]
)
interface AppComponent {
    fun inject(@NotNull application: PokeappApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}