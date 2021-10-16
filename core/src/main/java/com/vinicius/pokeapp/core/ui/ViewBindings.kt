package com.vinicius.pokeapp.core.ui

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.graphics.toColorInt
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

private const val DEFAULT_COLOR = Color.GRAY

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
    textView.text = text?.replaceFirstChar{ it.uppercase() }
}

@BindingAdapter("pokemonTypeIcon")
fun setPokemonTypeIcon(imageView: ImageView, type: String?) {
    type?.let {
        imageView.setImageResource(Icons.valueOf(it.uppercase()).icon)
    }
}

@BindingAdapter("roundedBgColor")
fun setRoundedBackgroundColor(view: View, color: Int?) {
    color?.let {
        view.backgroundTintList = ColorStateList.valueOf(it)
    } ?: run {
        view.setBackgroundColor(DEFAULT_COLOR)
    }
}

@BindingAdapter("bgColor")
fun setBackgroundColor(view: View, color: Int?) {
    color?.let {
        view.setBackgroundColor(it)
    } ?: run {
        view.setBackgroundColor(DEFAULT_COLOR)
    }
}

@BindingAdapter("txtColor")
fun setTextColor(textView: TextView, color: Int?) {
    color?.let {
        textView.setTextColor(color)
    } ?: run {
        textView.setBackgroundColor(DEFAULT_COLOR)
    }
}

@BindingAdapter("progressColor")
fun setProgressColor(progressBar: ProgressBar, color: Int?) {
    color?.let {
        progressBar.progressTintList = ColorStateList.valueOf(it)
    } ?: run {
        progressBar.progressTintList = ColorStateList.valueOf(DEFAULT_COLOR)
    }
}

@BindingAdapter("progressValue")
fun setProgressValue(progressBar: ProgressBar, value: String?) {
    progressBar.progress = value?.toInt() ?: 0
}

@BindingAdapter("showView")
fun showView(view: View, canShow: Boolean) {
    view.visibility = if (canShow) View.VISIBLE else View.GONE
}