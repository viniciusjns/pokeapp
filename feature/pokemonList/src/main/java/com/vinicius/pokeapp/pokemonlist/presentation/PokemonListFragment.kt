package com.vinicius.pokeapp.pokemonlist.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.vinicius.pokeapp.core.views.BaseFragment
import com.vinicius.pokeapp.pokemondetail.presentation.PokemonDetailFragment
import com.vinicius.pokeapp.service.response.Pokemon
import com.vinicius.pokemonlist.R
import com.vinicius.pokemonlist.databinding.PokemonListFragmentBinding

class PokemonListFragment : BaseFragment() {

    private lateinit var binding: PokemonListFragmentBinding
    private val viewModel by lazy { getViewModel(PokemonListViewModel::class.java) }
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

        setupList()
        observeChanges()
    }

    private fun setupList() {
        pokemonListAdapter = PokemonListAdapter { pokemon ->
            openPokemonDetail(pokemon)
        }
        binding.rvPokemonList.adapter = pokemonListAdapter
    }

    private fun observeChanges() {
        viewModel.viewState.state.observe(
            viewLifecycleOwner, {
                when (it) {
                    PokemonListViewState.State.LOADING -> {
                        binding.givLoading.visibility = View.VISIBLE
                        binding.tvEmptyResult.visibility = View.GONE
                    }
                    PokemonListViewState.State.SUCCESS -> {
                        binding.givLoading.visibility = View.GONE
                        binding.tvEmptyResult.visibility = View.GONE
                    }
                    PokemonListViewState.State.EMPTY -> {
                        binding.givLoading.visibility = View.GONE
                        binding.tvEmptyResult.visibility = View.VISIBLE
                    }
                    PokemonListViewState.State.ERROR -> {
                        binding.givLoading.visibility = View.GONE
                        binding.tvEmptyResult.visibility = View.VISIBLE
                    }
                }
            }
        )
        viewModel.viewState.action.observe(
            viewLifecycleOwner, {
                when (it) {
                    is PokemonListViewState.Action.SetupPokemonList -> updateList()
                }
            }
        )
    }

    private fun updateList() {
        viewModel.viewState.pokemonLiveData.value?.let {
            pokemonListAdapter.updateList(it)
        }
    }

    private fun openPokemonDetail(pokemon: Pokemon) {
        requireActivity().supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, PokemonDetailFragment.newInstance(pokemon))
            .addToBackStack(null)
            .commit()
    }

    companion object {
        fun newInstance() = PokemonListFragment()
    }
}