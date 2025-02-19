package com.proyek.jtk.model

import android.net.Uri

data class Reward(
    val id: Long,
    val image: Uri?,
    val title: String,
    val requiredPoint: Int,
    val description: String
)