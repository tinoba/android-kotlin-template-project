package com.tinoba.template.extensions

import android.content.Context
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.support.annotation.ColorRes
import android.support.v4.content.ContextCompat

fun Drawable.setColorTheme(@ColorRes colorRes: Int, context: Context) {
    setColorFilter(ContextCompat.getColor(context, colorRes), PorterDuff.Mode.SRC_ATOP)
}