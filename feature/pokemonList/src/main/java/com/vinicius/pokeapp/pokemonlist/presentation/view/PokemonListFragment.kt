package com.vinicius.pokeapp.pokemonlist.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.vinicius.pokeapp.core.extensions.loadGif
import com.vinicius.pokeapp.core.extensions.loadImage
import com.vinicius.pokeapp.core.views.BaseFragment
import com.vinicius.pokeapp.pokemondetail.presentation.view.PokemonDetailFragment
import com.vinicius.pokeapp.pokemonlist.presentation.adapter.PokemonListAdapter
import com.vinicius.pokeapp.pokemonlist.presentation.model.PokemonListUiModel
import com.vinicius.pokemonlist.R
import com.vinicius.pokemonlist.databinding.PokemonListFragmentBinding

class PokemonListFragment : BaseFragment() {

    private lateinit var binding: PokemonListFragmentBinding
    private val viewModel by lazy { getViewModel(PokemonListViewModel::class.java) }
    private val pokemonListAdapter: PokemonListAdapter by lazy {
        PokemonListAdapter { pokemon ->
            openPokemonDetail(pokemon)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PokemonListFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.dispatchViewAction(PokemonListViewAction.GetPokemons)

        setupView()
        observeChanges()
    }

    private fun setupView() = with(binding) {
        ivLoading.loadGif(R.drawable.pikachu_running)

        rvPokemonList.adapter = pokemonListAdapter
    }

    private fun observeChanges() {
        viewModel.viewState.state.observe(
            viewLifecycleOwner
        ) { state ->
            when (state) {
                PokemonListViewState.State.LOADING -> {
                    binding.ivLoading.isVisible = true
                    binding.pokemonNotFoundScreen.root.isVisible = false
                }
                PokemonListViewState.State.SUCCESS -> {
                    binding.ivLoading.isVisible = false
                    binding.pokemonNotFoundScreen.root.isVisible = false
                }
                PokemonListViewState.State.ERROR -> {
                    binding.ivLoading.isVisible = false
                    binding.pokemonNotFoundScreen.root.isVisible = true
                }
            }
        }
        viewModel.viewState.action.observe(
            viewLifecycleOwner
        ) {
            when (it) {
                is PokemonListViewState.Action.SetupPokemonList -> updateList()
            }
        }
    }

    private fun updateList() {
        viewModel.viewState.pokemonLiveData.observe(viewLifecycleOwner) {
            pokemonListAdapter.submitList(it)
        }
    }

    private fun openPokemonDetail(pokemon: PokemonListUiModel) {
        requireActivity().supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                R.anim.slide_in,
                R.anim.fade_out,
                R.anim.fade_in,
                R.anim.slide_out
            )
            .add(R.id.container, PokemonDetailFragment.newInstance(pokemon.id.toInt()))
            .addToBackStack(null)
            .commit()
    }

    companion object {
        fun newInstance() = PokemonListFragment()
    }
}