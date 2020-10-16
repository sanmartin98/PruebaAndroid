package com.example.pruebaandroid.model

import com.google.gson.annotations.SerializedName

data class Album(
    @SerializedName("userId")
    val userId:Int? = null,
    @SerializedName("id")
    val albumId:Int? = null,
    @SerializedName("title")
    val title:String? = null
)