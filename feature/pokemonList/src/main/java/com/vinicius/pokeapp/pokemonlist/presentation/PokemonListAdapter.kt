package com.vinicius.pokeapp.pokemonlist.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vinicius.pokeapp.service.response.Pokemon
import com.vinicius.pokemonlist.databinding.PokemonListItemBinding

class PokemonListAdapter(
    private val pokemonList: List<Pokemon>
) : RecyclerView.Adapter<PokemonListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PokemonListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemon = pokemonList[position]
        holder.onBind(pokemon)
    }

    override fun getItemCount(): Int = pokemonList.size

    inner class ViewHolder(
        private val binding: PokemonListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(pokemon: Pokemon) {
            binding.pokemon = pokemon
        }

    }

}