package com.vinicius.pokeapp.pokemondetail.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vinicius.pokeapp.core.views.BaseFragment
import com.vinicius.pokeapp.pokemondetail.presentation.model.PokemonAboutModel
import com.vinicius.pokemondetail.databinding.PokemonAboutFragmentBinding

private const val POKEMON = "POKEMON"
private const val COLOR_TYPE = "COLOR_TYPE"

class PokemonAboutFragment : BaseFragment() {
    private var pokemon: PokemonAboutModel? = null
    private var colorType = -1

    private lateinit var binding: PokemonAboutFragmentBinding

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
        binding = PokemonAboutFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.pokemon = pokemon
        binding.colorType = colorType
    }

    companion object {
        fun newInstance(pokemon: PokemonAboutModel?, colorType: Int?) =
            PokemonAboutFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(POKEMON, pokemon)
                    putInt(COLOR_TYPE, colorType ?: -1)
                }
            }
    }
}