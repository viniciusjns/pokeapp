package com.vinicius.pokeapp.di

import com.vinicius.pokeapp.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @Activity
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity
}