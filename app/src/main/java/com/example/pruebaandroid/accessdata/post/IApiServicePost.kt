package com.example.pruebaandroid.accessdata.post

import com.example.pruebaandroid.constants.WS_GET_POSTS
import com.example.pruebaandroid.model.Post
import retrofit2.http.GET
import retrofit2.http.Query

interface IApiServicePost {
    @GET(WS_GET_POSTS)
    suspend fun getPostsByUserId(@Query("userId") userId: Int) : List<Post>
}