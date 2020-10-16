package com.example.pruebaandroid.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("phone")
    val tel: String? = null,
    @SerializedName("email")
    val email: String? = null
): Parcelable