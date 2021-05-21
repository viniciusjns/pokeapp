package com.vinicius.pokeapp.pokemonlist.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vinicius.pokeapp.service.response.Pokemon
import com.vinicius.pokemonlist.databinding.PokemonListItemBinding

class PokemonListAdapter(
    private val showPokemonDetail: (Pokemon) -> Unit
) : RecyclerView.Adapter<PokemonListAdapter.ViewHolder>() {

    private val pokemons = mutableListOf<Pokemon>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PokemonListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemon = pokemons[position]
        holder.onBind(pokemon)
    }

    override fun getItemCount(): Int = pokemons.size

    fun updateList(newList: List<Pokemon>) {
        val diffResult = DiffUtil.calculateDiff(PokemonDiffCallback(this.pokemons, newList))
        this.pokemons.clear()
        this.pokemons.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }

    inner class ViewHolder(
        private val binding: PokemonListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(pokemon: Pokemon) {
            binding.pokemon = pokemon

            binding.root.setOnClickListener {
                showPokemonDetail(pokemon)
            }
        }
    }
}

class PokemonDiffCallback(
    val newList: List<Pokemon>,
    val oldList: List<Pokemon>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

}