package com.vinicius.pokeapp.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vinicius.pokeapp.database.entity.PokemonEntity

@Dao
interface PokemonDao {

    @Query("SELECT * FROM tb_pokemon")
    suspend fun getPokemons(): List<PokemonEntity>

    @Query("SELECT * FROM tb_pokemon WHERE id = :id")
    suspend fun getPokemonById(id: Int): PokemonEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun savePokemons(pokemons: List<PokemonEntity>)
}