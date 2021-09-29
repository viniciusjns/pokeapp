package com.vinicius.pokeapp.pokemondetail.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vinicius.pokeapp.core.views.BaseFragment
import com.vinicius.pokeapp.pokemondetail.presentation.adapter.PokemonTypeDefenseAdapter
import com.vinicius.pokeapp.pokemondetail.presentation.model.PokemonStatsModel
import com.vinicius.pokemondetail.databinding.PokemonStatsFragmentBinding

private const val POKEMON = "POKEMON"

class PokemonStatsFragment : BaseFragment() {
    private var pokemon: PokemonStatsModel? = null

    private lateinit var binding: PokemonStatsFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            pokemon = it.getParcelable(POKEMON)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PokemonStatsFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.pokemon = pokemon

        binding.rvTypeDefenses.adapter = pokemon?.let { PokemonTypeDefenseAdapter(it.typeDefenses) }
    }

    companion object {
        fun newInstance(pokemon: PokemonStatsModel?) =
            PokemonStatsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(POKEMON, pokemon)
                }
            }
    }
}