package com.vinicius.pokeapp

import android.app.Application
import com.vinicius.pokeapp.di.AppComponent
import com.vinicius.pokeapp.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class PokeappApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Any>

    lateinit var appComponent: AppComponent

    override fun androidInjector(): AndroidInjector<Any> = dispatchingActivityInjector

    override fun onCreate() {
        super.onCreate()

        initInjector()
    }

    private fun initInjector() {
        appComponent = getDaggerAppComponent()
        appComponent.inject(this)
    }

    private fun getDaggerAppComponent() =
        DaggerAppComponent.builder()
            .application(this)
            .build()
}