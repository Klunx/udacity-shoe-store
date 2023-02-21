package com.udacity.shoestore.utils

import android.view.View

/**
 * Approach taken from previous projects that I have work on.
 */
fun View.setGone() {
    this.visibility = View.GONE
}

fun View.setVisible() {
    this.visibility = View.VISIBLE
}

fun String.validateDescription(): String {
    return this.ifEmpty {
        "N/A"
    }
}