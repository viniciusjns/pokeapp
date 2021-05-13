package com.vinicius.pokeapp.pokemonlist.presentation

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.toColorInt
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vinicius.pokeapp.core.ui.Colors
import com.vinicius.pokeapp.core.ui.Icons
import com.vinicius.pokeapp.service.response.Pokemon
import com.vinicius.pokemonlist.databinding.PokemonListItemBinding

class PokemonListAdapter(
    val pokemonList: List<Pokemon>
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
            binding.tvNumber.text = pokemon.getNumber()
            binding.tvName.text = pokemon.getCapsName()

            pokemon.types?.let {
                with(binding.layoutType1) {
                    this.tvType.text = it[0].capitalize()
                    this.ivIcon.setImageResource(Icons.valueOf(it[0].toUpperCase()).icon)
                    this.container.backgroundTintList = ColorStateList.valueOf(Colors.Type.valueOf(it[0].toUpperCase()).color.toColorInt())
                }

                with(binding.layoutType2) {
                    if (it.size > 1) {
                        this.root.visibility = View.VISIBLE
                        this.tvType.text = it[1].capitalize()
                        this.ivIcon.setImageResource(Icons.valueOf(it[1].toUpperCase()).icon)
                        this.container.backgroundTintList = ColorStateList.valueOf(Colors.Type.valueOf(it[1].toUpperCase()).color.toColorInt())
                    } else
                        this.root.visibility = View.GONE
                }
            }

            binding.flContainer.backgroundTintList = pokemon.types?.get(0)?.let { type ->
                Colors.BackgroundType.valueOf(type.toUpperCase()).color.toColorInt()
            }?.let { color ->
                ColorStateList.valueOf(color)
            }

            Glide.with(binding.root)
                    .load(pokemon.image)
                    .into(binding.ivPicture)

//            Glide.with(binding.root)
//                .load(pokemon.getImageUrl())
//                .listener(
//                    GlidePalette.with(pokemon.getImageUrl())
//                        .use(BitmapPalette.Profile.MUTED_LIGHT)
//                        .intoCallBack { palette ->
//                            val rgb = palette?.dominantSwatch?.rgb
//                            if (rgb != null) {
//                                binding.flContainer.backgroundTintList = ColorStateList.valueOf(rgb)
//                            }
//                        }.crossfade(true)
//                ).into(binding.ivPicture)
        }

    }

}