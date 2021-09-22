package com.vinicius.pokeapp.pokemondetail.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vinicius.pokeapp.pokemondetail.presentation.model.PokemonStatsModel
import com.vinicius.pokemondetail.databinding.PokemonStatsFragmentBinding

private const val POKEMON = "POKEMON"
private const val COLOR_TYPE = "COLOR_TYPE"

class PokemonStatsFragment : Fragment() {
    private var pokemon: PokemonStatsModel? = null
    private var colorType = -1

    private lateinit var binding: PokemonStatsFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            pokemon = it.getParcelable(POKEMON)
            colorType = it.getInt(COLOR_TYPE)
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
        binding.colorType = colorType

        binding.rvTypeDefenses.adapter = pokemon?.let { PokemonTypeDefenseAdapter(it.typeDefenses) }
    }

    companion object {
        fun newInstance(pokemon: PokemonStatsModel?, colorType: Int?) =
            PokemonStatsFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(POKEMON, pokemon)
                    putInt(COLOR_TYPE, colorType ?: -1)
                }
            }
    }
}