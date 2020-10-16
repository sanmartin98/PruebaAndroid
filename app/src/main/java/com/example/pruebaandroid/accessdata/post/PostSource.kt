package com.example.pruebaandroid.accessdata.post

import com.example.pruebaandroid.accessdata.config.Resource
import com.example.pruebaandroid.accessdata.config.RetrofitClient
import com.example.pruebaandroid.model.Post

class PostSource {

    suspend fun getPostByUserId(userId: Int): Resource<List<Post>>{
        return Resource.Success(RetrofitClient().getRetroInstance().create(IApiServicePost::class.java).getPostsByUserId(userId))
    }

}