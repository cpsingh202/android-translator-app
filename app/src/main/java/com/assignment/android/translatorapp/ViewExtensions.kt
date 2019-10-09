package com.assignment.android.translatorapp

import android.widget.TextView

fun TextView.getKey(): String {
    return when (this.id) {
        R.id.tv_message -> "message"
        else -> ""
    }
}