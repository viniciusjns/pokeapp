package com.vinicius.pokeapp.pokemonlist.di

import android.app.Application
import androidx.lifecycle.ViewModel
import com.squareup.moshi.Moshi
import com.vinicius.pokeapp.core.di.ViewModelKey
import com.vinicius.pokeapp.pokemonlist.data.datasource.PokemonListLocalDataSource
import com.vinicius.pokeapp.pokemonlist.data.datasource.PokemonListLocalDataSourceImpl
import com.vinicius.pokeapp.pokemonlist.data.datasource.PokemonListRemoteDataSource
import com.vinicius.pokeapp.pokemonlist.data.datasource.PokemonListRemoteDataSourceImpl
import com.vinicius.pokeapp.pokemonlist.domain.repository.PokemonListRepository
import com.vinicius.pokeapp.pokemonlist.data.repository.PokemonListRepositoryImpl
import com.vinicius.pokeapp.pokemonlist.data.service.PokeappService
import com.vinicius.pokeapp.pokemonlist.domain.useCase.GetPokemonsUseCase
import com.vinicius.pokeapp.pokemonlist.domain.useCase.GetPokemonsUseCaseImpl
import com.vinicius.pokeapp.pokemonlist.presentation.view.PokemonListFragment
import com.vinicius.pokeapp.pokemonlist.presentation.view.PokemonListViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

@Module(
    includes = [
        PokemonListDataModule::class,
        PokemonListDomainModule::class,
        PokemonListPresentationModule::class,
        PokemonListServiceModule::class,
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
    fun bindGetPokemonsUseCase(
        getPokemonsUseCase: GetPokemonsUseCaseImpl
    ): GetPokemonsUseCase
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

@Module
object PokemonListServiceModule {

    @[Provides Reusable]
    internal fun provideCache(application: Application): Cache {
        val cacheSize = (1024 * 1024 * 10).toLong() // 10MB
        return Cache(application.cacheDir, cacheSize)
    }

    @[Provides Reusable]
    internal fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @[Provides Reusable]
    internal fun provideOkHttpClient(
        cache: Cache,
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .cache(cache)
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @[Provides Reusable]
    internal fun provideMoshiClient(): MoshiConverterFactory {
        val moshi = Moshi.Builder()
            .build()

        return MoshiConverterFactory.create(moshi)
    }

    @[Provides Reusable]
    internal fun provideRetrofit(
        okHttpClient: OkHttpClient,
        moshiConverterFactory: MoshiConverterFactory,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://pokemon-db-json.herokuapp.com/")
            .addConverterFactory(moshiConverterFactory)
            .client(okHttpClient)
            .build()
    }

    @[Provides Reusable]
    internal fun providePokeappService(retrofit: Retrofit): PokeappService {
        return retrofit.create(PokeappService::class.java)
    }

}