package com.vinicius.pokeapp.database.converters

import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class Converters {

    private val moshi: Moshi = Moshi.Builder().build()

    @TypeConverter
    fun stringListToString(list: List<String>?): String = if (list.isNullOrEmpty()) {
        ""
    } else {
        val type = Types.newParameterizedType(List::class.java, String::class.java)
        val jsonAdapter = moshi.adapter<List<String>?>(type)
        jsonAdapter.toJson(list) ?: ""
    }

    @TypeConverter
    fun stringToStringList(string: String?): List<String>? = if (string.isNullOrBlank()) {
        emptyList()
    } else {
        val type = Types.newParameterizedType(List::class.java, String::class.java)
        val jsonAdapter = moshi.adapter<List<String>?>(type)
        jsonAdapter.fromJson(string) ?: emptyList()
    }

    @TypeConverter
    fun intListToString(list: List<Int>): String = if (list.isNullOrEmpty()) {
        ""
    } else {
        val type = Types.newParameterizedType(List::class.java, Integer::class.java)
        val jsonAdapter = moshi.adapter<List<Int>?>(type)
        jsonAdapter.toJson(list) ?: ""
    }

    @TypeConverter
    fun stringToIntList(string: String): List<Int> = if (string.isBlank()) {
        emptyList()
    } else {
        val type = Types.newParameterizedType(List::class.java, Integer::class.java)
        val jsonAdapter = moshi.adapter<List<Int>?>(type)
        jsonAdapter.fromJson(string) ?: emptyList()
    }
}