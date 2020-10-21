package com.example.pruebaandroid.accessdata.post

import com.example.pruebaandroid.accessdata.config.Resource
import com.example.pruebaandroid.accessdata.config.RetrofitClient
import com.example.pruebaandroid.model.Post
import io.reactivex.Observable

class PostSource {

    fun getPostByUserId(userId: Int): Observable<List<Post>>{
        return RetrofitClient().getRetroInstance().create(IApiServicePost::class.java).getPostsByUserId(userId)
    }

}