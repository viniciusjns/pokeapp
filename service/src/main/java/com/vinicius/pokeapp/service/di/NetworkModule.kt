package com.vinicius.pokeapp.service.di

import com.vinicius.pokeapp.service.service.APIClient
import com.vinicius.pokeapp.service.service.APIClientImpl
import com.vinicius.pokeapp.service.service.PokeappService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
open class NetworkModule {

    @Provides
    @Singleton
    fun providesApiClient(): APIClient = APIClientImpl()

    @Singleton
    @Provides
    fun providesService(retrofit: Retrofit): PokeappService =
        retrofit.create(PokeappService::class.java)

    @Provides
    @Singleton
    fun provideRetrofit(apiClient: APIClient): Retrofit =
        apiClient.configure("https://pokeapi.co/api/v2/")

}