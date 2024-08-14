package com.example.movie.network.model.post

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PostDataItem(
    @Json(name = "content")
    val content: String,
    @Json(name = "created_at")
    val created_at: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "movie")
    val movie: String?,
    @Json(name = "title")
    val title: String
)