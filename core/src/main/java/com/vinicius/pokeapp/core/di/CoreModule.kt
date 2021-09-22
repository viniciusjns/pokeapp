package com.vinicius.pokeapp.core.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
interface CoreModule {
    @[Binds Reusable]
    fun bindViewModelFactory(
        factory: ViewModelProviderFactory
    ): ViewModelProvider.Factory
}