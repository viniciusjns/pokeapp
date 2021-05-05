package com.vinicius.service.di

import com.vinicius.core.service.APIClient
import com.vinicius.core.service.APIClientImpl
import com.vinicius.service.service.PokeappService
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