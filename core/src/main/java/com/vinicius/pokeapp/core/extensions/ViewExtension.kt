package com.vinicius.pokeapp.core.extensions

import android.animation.ObjectAnimator
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.graphics.drawable.ScaleDrawable
import android.view.View
import android.view.animation.AnimationUtils
import android.view.animation.DecelerateInterpolator
import android.view.animation.LinearInterpolator
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.bumptech.glide.Glide
import com.vinicius.core.R
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

fun ProgressBar.tintProgress(color: Int?, drawable: ScaleDrawable?) {
    color?.let { color ->
        drawable?.let { drawable ->
            drawable.colorFilter = PorterDuffColorFilter(color, PorterDuff.Mode.SRC_IN)
            progressDrawable = drawable.mutate()
        } ?: run {
                progressTintList = ColorStateList.valueOf(DEFAULT_COLOR)
            }
    } ?: run {
        progressTintList = ColorStateList.valueOf(DEFAULT_COLOR)
    }
}

fun ProgressBar.animateProgressBarHorizontal(progress: Int) {
    ObjectAnimator.ofInt(this, "progress", progress)
        .setDuration(500L)
        .start()
}

