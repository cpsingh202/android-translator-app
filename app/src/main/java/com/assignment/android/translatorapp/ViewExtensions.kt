package com.assignment.android.translatorapp

import android.widget.TextView

fun TextView.getKey(): String {
    return when (this.id) {
        R.id.tv_message -> "message"
        R.id.tv_subject -> "subject"
        R.id.tv_body -> "body"
        R.id.tv_signature -> "signature"
        R.id.tv_address_1 -> "address1"
        R.id.tv_address_2 -> "address2"
        else -> ""
    }
}