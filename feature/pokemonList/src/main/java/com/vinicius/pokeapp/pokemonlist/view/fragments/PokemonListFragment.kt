package com.vinicius.pokeapp.pokemonlist.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.vinicius.pokeapp.core.views.BaseFragment
import com.vinicius.pokeapp.pokemonlist.view.adapters.PokemonListAdapter
import com.vinicius.pokeapp.service.service.PokeappService
import com.vinicius.pokemonlist.databinding.PokemonListFragmentBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonListFragment : BaseFragment() {

    @Inject
    lateinit var pokeappService: PokeappService

    private lateinit var binding: PokemonListFragmentBinding
    private lateinit var pokemonListAdapter: PokemonListAdapter

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
//                limit = 200,
//                offset = 0
//            ).results
            val result = pokeappService.fetchPokemonsHeroku()
            val sort = result.sortedBy { it.getNumber() }
            pokemonListAdapter = PokemonListAdapter(sort)
//            val result = pokeappService.fetchPokemonById(1)
            withContext(Dispatchers.Main) {
                binding.givLoading.visibility = View.GONE
                binding.rvPokemonList.apply {
                    layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                    adapter = pokemonListAdapter
                }
            }
        }
    }

    companion object {
        fun newInstance() = PokemonListFragment()
    }
}