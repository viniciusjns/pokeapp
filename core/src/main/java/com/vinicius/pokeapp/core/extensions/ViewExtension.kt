package com.vinicius.pokeapp.core.extensions

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.bumptech.glide.Glide
import com.vinicius.pokeapp.core.ui.Icons

private const val DEFAULT_COLOR = Color.GRAY

fun View.tintBackground(color: Int?) {
    color?.let {
        backgroundTintList = ColorStateList.valueOf(it)
    } ?: run {
        backgroundTintList = ColorStateList.valueOf(DEFAULT_COLOR)
    }
}

fun ImageView.loadImage(url: String?) {
    url?.let {
        Glide.with(context)
            .load(it)
            .centerCrop()
            .into(this)
    }
}

fun ImageView.loadImage(icon: Int?) {
    icon?.let {
        Glide.with(context)
            .load(it)
            .centerCrop()
            .into(this)
    }
}

fun ImageView.loadGif(icon: Int) {
    Glide.with(context).asGif()
        .load(icon)
        .into(this)
}

fun ImageView.setIcon(icon: String?) {
    icon?.let {
        setImageResource(Icons.valueOf(it.uppercase()).icon)
    }
}

fun TextView.capitalize(string: String?) {
    text = string?.replaceFirstChar{ it.uppercase() }
}

fun ProgressBar.tintProgress(color: Int?) {
    color?.let {
        progressTintList = ColorStateList.valueOf(it)
    } ?: run {
        progressTintList = ColorStateList.valueOf(DEFAULT_COLOR)
    }
}

