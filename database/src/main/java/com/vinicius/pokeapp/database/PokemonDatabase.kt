package com.vinicius.pokeapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.vinicius.pokeapp.database.converters.Converters
import com.vinicius.pokeapp.database.dao.PokemonDao
import com.vinicius.pokeapp.database.entity.PokemonEntity

private const val DB_VERSION = 1
private const val DB_NAME = "POKEMON"

@Database(
    entities = [
        PokemonEntity::class
    ],
    version = DB_VERSION
)
@TypeConverters(Converters::class)
abstract class PokemonDatabase : RoomDatabase() {

    abstract fun pokemonDao(): PokemonDao

    companion object {
        fun createDatabase(context: Context): PokemonDatabase =
            Room.databaseBuilder(
                context,
                PokemonDatabase::class.java,
                DB_NAME
            ).fallbackToDestructiveMigration().build()
    }
}