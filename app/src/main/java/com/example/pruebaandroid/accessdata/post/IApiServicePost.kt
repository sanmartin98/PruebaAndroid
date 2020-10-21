package com.example.pruebaandroid.accessdata.post

import com.example.pruebaandroid.constants.WS_GET_POSTS
import com.example.pruebaandroid.model.Post
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface IApiServicePost {
    @GET(WS_GET_POSTS)
    fun getPostsByUserId(@Query("userId") userId: Int) : Observable<List<Post>>
}