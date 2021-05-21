package com.vinicius.pokeapp.di

import android.app.Application
import com.vinicius.pokeapp.PokeappApplication
import com.vinicius.pokeapp.pokemondetail.di.PokemonDetailModule
import com.vinicius.pokeapp.pokemonlist.di.PokemonListModule
import com.vinicius.pokeapp.service.di.ServiceModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import org.jetbrains.annotations.NotNull
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        ActivityModule::class,
        ServiceModule::class,
        PokemonListModule::class,
        PokemonDetailModule::class,
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