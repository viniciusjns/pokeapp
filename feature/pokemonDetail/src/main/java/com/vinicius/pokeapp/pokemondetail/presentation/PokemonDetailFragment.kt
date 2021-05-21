package com.vinicius.pokeapp.pokemondetail.presentation

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.transition.TransitionInflater
import com.vinicius.pokeapp.core.views.BaseFragment
import com.vinicius.pokeapp.service.response.Pokemon
import com.vinicius.pokemondetail.databinding.PokemonDetailFragmentBinding

private const val POKEMON = "POKEMON"

class PokemonDetailFragment : BaseFragment() {

    private var pokemon: Pokemon? = null

    private lateinit var binding: PokemonDetailFragmentBinding
//    private val viewModel by lazy { getViewModel(PokemonDetailViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedElementEnterTransition =
            TransitionInflater.from(context).inflateTransition(android.R.transition.fade)
        exitTransition =
            TransitionInflater.from(context).inflateTransition(android.R.transition.slide_left)
        enterTransition =
            TransitionInflater.from(context).inflateTransition(android.R.transition.slide_right)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PokemonDetailFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pokemon = arguments?.getParcelable(POKEMON)
        binding.pokemon = pokemon

        binding.toolbar.backButton.setOnClickListener {
            activity?.onBackPressed()
        }

        observeChanges()
    }

    private fun observeChanges() {

    }

    companion object {
        fun newInstance(pokemon: Pokemon): PokemonDetailFragment {
            return PokemonDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(POKEMON, pokemon)
                }
            }
        }
    }

}