package com.vinicius.pokeapp.core.di

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import com.squareup.moshi.Moshi
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

@Module(
    includes = [
        ViewModelFactoryModule::class,
        CoreServiceModule::class
    ]
)
object CoreModule

@Module
interface ViewModelFactoryModule {
    @[Binds Reusable]
    fun bindViewModelFactory(
        factory: ViewModelProviderFactory
    ): ViewModelProvider.Factory
}

@Module
object CoreServiceModule {

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

}