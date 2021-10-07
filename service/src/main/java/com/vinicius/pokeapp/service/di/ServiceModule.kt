package com.vinicius.pokeapp.service.di

import android.app.Application
import com.squareup.moshi.Moshi
import com.vinicius.pokeapp.service.service.PokeappService
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

@Module
object ServiceModule {

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideCache(application: Application): Cache {
        val cacheSize = (1024 * 1024 * 10).toLong() // 10MB
        return Cache(application.cacheDir, cacheSize)
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideOkHttpClient(cache: Cache): OkHttpClient {
        return OkHttpClient.Builder()
            .cache(cache)
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideMoshiClient(): MoshiConverterFactory {
        val moshi = Moshi.Builder()
            .build()

        return MoshiConverterFactory.create(moshi)
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofitInterface(okHttpClient: OkHttpClient,
                                          moshiConverterFactory: MoshiConverterFactory,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://pokemon-db-json.herokuapp.com/")
            .addConverterFactory(moshiConverterFactory)
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideMarvelApi(retrofit: Retrofit): PokeappService {
        return retrofit.create(PokeappService::class.java)
    }

}