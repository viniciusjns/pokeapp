package com.vinicius.pokeapp.pokemonlist.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.vinicius.pokeapp.core.BaseFragment
import com.vinicius.pokeapp.service.response.Pokemon
import com.vinicius.pokeapp.service.service.PokeappService
import com.vinicius.pokemonlist.R
import com.vinicius.pokemonlist.databinding.PokemonListFragmentBinding
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonListFragment : BaseFragment() {

    @Inject
    lateinit var pokeappService: PokeappService

    private lateinit var binding: PokemonListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PokemonListFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        CoroutineScope(Dispatchers.IO).launch {
//            val result = pokeappService.fetchPokemonList(
//                limit = 20,
//                offset = 0
//            )
            val result = pokeappService.fetchPokemonById(1)
            withContext(Dispatchers.Main) {
//                teste.text = result.results.toString()
                binding.teste.text = result.name
            }
        }
    }

    companion object {
        fun newInstance() = PokemonListFragment()
    }
}