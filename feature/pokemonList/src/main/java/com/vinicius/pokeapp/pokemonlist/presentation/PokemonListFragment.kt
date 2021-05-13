package com.vinicius.pokeapp.pokemonlist.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.vinicius.pokeapp.core.views.BaseFragment
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

        observeChanges()

        viewModel.dispatchViewAction(PokemonListViewAction.FetchPokemonHeroku)

    }

    private fun observeChanges() {
        viewModel.viewState.state.observe(
            viewLifecycleOwner, {
                when(it) {
                    PokemonListViewState.State.LOADING -> binding.givLoading.visibility = View.VISIBLE
                    else -> binding.givLoading.visibility = View.GONE
                }
            }
        )
        viewModel.viewState.action.observe(
            viewLifecycleOwner, {
                when(it) {
                    is PokemonListViewState.Action.SetupPokemonList -> setupList()
                }
            }
        )
    }

    private fun setupList() {
        viewModel.viewState.pokemonLiveData.value?.let {
            pokemonListAdapter = PokemonListAdapter(it)
        }
        binding.rvPokemonList.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = pokemonListAdapter
        }
    }

    companion object {
        fun newInstance() = PokemonListFragment()
    }
}