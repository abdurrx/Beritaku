package com.dicoding.beritaku.model

import java.io.Serializable

data class Berita(
    val id: Int,
    val title: String,
    val desc: String,
    val author: String,
    val date: String,
    val photoUrl: String
): Serializable
