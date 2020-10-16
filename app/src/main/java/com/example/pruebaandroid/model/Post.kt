package com.example.pruebaandroid.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class Post (
    @SerializedName("userId")
    val userId:Int? = null,
    @SerializedName("id")
    val postId:Int? = null,
    @SerializedName("title")
    val title:String? = null,
    @SerializedName("body")
    val body:String? = null
)