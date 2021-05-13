package com.vinicius.pokeapp.di

import com.vinicius.pokeapp.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityModule {
    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity
}