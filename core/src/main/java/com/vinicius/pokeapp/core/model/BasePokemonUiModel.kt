package com.vinicius.pokeapp.core.model

import android.os.Parcelable
import androidx.core.graphics.toColorInt
import com.vinicius.pokeapp.core.ui.Colors
import kotlinx.parcelize.Parcelize

@Parcelize
open class BasePokemonUiModel(
    @Transient open val id: String,
    @Transient open val name: String,
    @Transient open val types: List<String>?,
    @Transient open val imageUrl: String?,
) : Parcelable {

    val bgColor: Int?
        get() = types?.let {
            Colors.valueOf(it[0].uppercase()).background.toColorInt()
        }

    val typeColors: List<Int>?
        get() = types?.let {
            it.map { Colors.valueOf(it.uppercase()).type.toColorInt() }
        }

    val canShowSecondType: Boolean
        get() = types?.let {
            it.size > 1
        } == true

    fun getNumber(): String {
        val number = id.padStart(3, '0')
        return "#${number}"
    }
}