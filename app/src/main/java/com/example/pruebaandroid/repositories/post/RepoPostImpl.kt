package com.example.pruebaandroid.repositories.post

import com.example.pruebaandroid.accessdata.config.Resource
import com.example.pruebaandroid.accessdata.post.PostSource
import com.example.pruebaandroid.model.Post
import io.reactivex.Observable

class RepoPostImpl(private val postSource: PostSource):IRepoPost {
    override fun getPostByUserId(userId: Int): Observable<List<Post>> {
        return postSource.getPostByUserId(userId)
    }
}