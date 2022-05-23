package com.vinicius.pokeapp.pokemondetail.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vinicius.pokeapp.pokemondetail.presentation.model.TypeDefense
import com.vinicius.pokemondetail.databinding.PokemonTypeDefenseItemBinding

class PokemonTypeDefenseAdapter(
) : ListAdapter<Pair<TypeDefense, String?>, PokemonTypeDefenseAdapter.ViewHolder>(
    PokemonTypeDefenseDiffCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PokemonTypeDefenseItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    override fun getItemCount(): Int = currentList.size

    inner class ViewHolder(val binding: PokemonTypeDefenseItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(typeDefense: Pair<TypeDefense, String?>) {
            Glide.with(binding.root.context).load(typeDefense.first.icon).into(binding.ivTypeDefense)
            binding.tvTypeDefenseLabel.text = typeDefense.second
        }
    }
}

class PokemonTypeDefenseDiffCallback : DiffUtil.ItemCallback<Pair<TypeDefense, String?>>() {

    override fun areItemsTheSame(
        oldItem: Pair<TypeDefense, String?>,
        newItem: Pair<TypeDefense, String?>
    ): Boolean = oldItem.first.name == newItem.first.name

    override fun areContentsTheSame(
        oldItem: Pair<TypeDefense, String?>,
        newItem: Pair<TypeDefense, String?>
    ): Boolean = oldItem == newItem
}