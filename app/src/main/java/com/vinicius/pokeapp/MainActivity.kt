package com.vinicius.pokeapp

import android.os.Bundle
import com.vinicius.pokeapp.core.views.BaseActivity
import com.vinicius.pokeapp.pokemonlist.presentation.PokemonListFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, PokemonListFragment.newInstance())
            .commitNow()
    }
}