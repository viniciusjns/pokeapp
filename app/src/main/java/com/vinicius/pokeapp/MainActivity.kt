package com.vinicius.pokeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.vinicius.service.service.PokeappService
import dagger.android.AndroidInjection
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var pokeappService: PokeappService

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val teste = findViewById<TextView>(R.id.teste)
        CoroutineScope(Dispatchers.IO).launch {
//            val result = pokeappService.fetchPokemonList(
//                limit = 20,
//                offset = 0
//            )
            val result = pokeappService.fetchPokemonById(1)
            withContext(Dispatchers.Main) {
//                teste.text = result.results.toString()
                teste.text = result.name
            }
        }
    }
}