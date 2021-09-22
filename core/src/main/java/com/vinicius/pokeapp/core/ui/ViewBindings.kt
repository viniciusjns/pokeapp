package com.vinicius.pokeapp.core.ui

import android.content.res.ColorStateList
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.graphics.toColorInt
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun loadImage(imageView: ImageView, url: String?) {
    url?.let {
        Glide.with(imageView.context)
            .load(it)
            .centerCrop()
            .into(imageView)
    }
}

@BindingAdapter("capitalize")
fun capitalize(textView: TextView, text: String?) {
    textView.text = text?.capitalize()
}

@BindingAdapter("pokemonTypeIcon")
fun setPokemonTypeIcon(imageView: ImageView, type: String?) {
    type?.let {
        imageView.setImageResource(Icons.valueOf(it.toUpperCase()).icon)
    }
}

@BindingAdapter("roundedBgColor")
fun setRoundedBackgroundColor(view: View, color: String?) {
    color?.let {
        view.backgroundTintList = ColorStateList.valueOf(it.toColorInt())
    }
}

@BindingAdapter("bgColor")
fun setBackgroundColor(view: View, color: String?) {
    color?.let {
        view.setBackgroundColor(it.toColorInt())
    }
}

@BindingAdapter("txtColor")
fun setTextColor(textView: TextView, color: Int?) {
    color?.let {
        textView.setTextColor(color)
    }
}

@BindingAdapter("progressColor")
fun setProgressColor(progressBar: ProgressBar, color: Int?) {
    color?.let {
        progressBar.progressTintList = ColorStateList.valueOf(it)
    }
}

@BindingAdapter("progressValue")
fun setProgressValue(progressBar: ProgressBar, value: String) {
    progressBar.progress = value.toInt()
}