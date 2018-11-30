package com.tinoba.template.extensions

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.annotation.ColorRes
import android.support.annotation.DrawableRes
import android.support.v4.content.ContextCompat
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE

fun View.isVisible() = visibility == VISIBLE

fun View.setBackgroundWithColorTheme(@DrawableRes drawableRes: Int, @ColorRes colorRes: Int, context: Context) {
    val drawable = ContextCompat.getDrawable(context, drawableRes)
    setBackgroundWithColorTheme(drawable!!, colorRes, context)
}

fun View.setBackgroundWithColorTheme(drawable: Drawable, @ColorRes colorRes: Int, context: Context) {
    drawable.setColorTheme(colorRes, context)
    background = drawable
}

fun View.show(show: Boolean = true) {
    visibility = if (show) VISIBLE else GONE
}

fun View.hide(hide: Boolean = true) {
    visibility = if (hide) GONE else VISIBLE
}