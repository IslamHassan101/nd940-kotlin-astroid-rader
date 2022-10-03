package com.islam.nd940_kotlin_astroid_rader

import com.squareup.moshi.Json

data class PictureOfDay(
    @Json(name = "media_type") val mediaType: String, val title: String,
    val url: String
)