package com.vinicius.pokeapp.pokemonlist.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vinicius.pokeapp.pokemonlist.presentation.model.PokemonListUiModel
import com.vinicius.pokemonlist.databinding.PokemonListItemBinding

class PokemonListAdapter(
    private val showPokemonDetail: (PokemonListUiModel) -> Unit
) : ListAdapter<PokemonListUiModel, PokemonListAdapter.ViewHolder>(PokemonDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PokemonListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemon = currentList[position]
        holder.onBind(pokemon)
    }

    override fun getItemCount(): Int = currentList.size

    inner class ViewHolder(
        private val binding: PokemonListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(pokemon: PokemonListUiModel) {
            binding.pokemon = pokemon

            binding.root.setOnClickListener {
                showPokemonDetail(pokemon)
            }
        }
    }
}

class PokemonDiffCallback : DiffUtil.ItemCallback<PokemonListUiModel>() {

    override fun areItemsTheSame(
        oldItem: PokemonListUiModel,
        newItem: PokemonListUiModel
    ): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: PokemonListUiModel,
        newItem: PokemonListUiModel
    ): Boolean = oldItem == newItem
}