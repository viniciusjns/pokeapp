package com.vinicius.pokeapp.pokemondetail.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vinicius.pokemondetail.databinding.PokemonAboutFragmentBinding

private const val POKEMON = "POKEMON"

class PokemonAboutFragment : Fragment() {
    private var pokemon: PokemonDetailUiModel? = null

    private lateinit var binding: PokemonAboutFragmentBinding

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
        binding = PokemonAboutFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.pokemon = pokemon
    }

    companion object {
        fun newInstance(pokemon: PokemonDetailUiModel?) =
            PokemonAboutFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(POKEMON, pokemon)
                }
            }
    }
}