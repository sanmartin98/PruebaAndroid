package com.example.pruebaandroid.repositories.post

import com.example.pruebaandroid.accessdata.config.Resource
import com.example.pruebaandroid.model.Post

interface IRepoPost {

    suspend fun getRepoByUserId(userId:Int):Resource<List<Post>>

}