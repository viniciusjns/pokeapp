package com.vinicius.pokeapp.service.service

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class APIClientImpl : APIClient {

    companion object {
        private const val TIMEOUT = 360

        lateinit var instance: APIClient
    }

    private val requestIntercept = { chain: Interceptor.Chain ->

        val original = chain.request()
        val originalHttpUrl = original.url()
        val url = originalHttpUrl.newBuilder()
            .build()

        val requestBuilder = original.newBuilder().url(url)
        val request = requestBuilder.build()

        chain.proceed(request)
    }

    private val client: OkHttpClient
        get() {
            val okHttp = OkHttpClient().newBuilder()
                .addInterceptor(requestIntercept)
                .connectTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
                .readTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
            okHttp.addInterceptor(loggingCapableHttpClient)

            return okHttp.build()
        }

    private val loggingCapableHttpClient: HttpLoggingInterceptor
        get() {
            val mLogging = HttpLoggingInterceptor()
            mLogging.level = HttpLoggingInterceptor.Level.BODY

            return mLogging
        }

    init {
        instance = this
    }

    override fun configure(baseUrl: String): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()

}