package com.example.pruebaandroid.model

import com.google.gson.annotations.SerializedName

data class Photo(
    @SerializedName("albumId")
    val albumId:Int? = null,
    @SerializedName("id")
    val photoId:Int? = null,
    @SerializedName("title")
    val title:String? = null,
    @SerializedName("thumbnailUrl")
    val url:String? = null
)