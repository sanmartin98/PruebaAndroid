package com.example.pruebaandroid.repositories.post

import com.example.pruebaandroid.model.Post
import io.reactivex.Observable

interface IRepoPost {

    fun getPostByUserId(userId:Int):Observable<List<Post>>

}