package com.example.pruebaandroid.repositories.post

import com.example.pruebaandroid.accessdata.config.Resource
import com.example.pruebaandroid.accessdata.post.PostSource
import com.example.pruebaandroid.model.Post

class RepoPostImpl(private val postSource: PostSource):IRepoPost {
    override suspend fun getPostByUserId(userId: Int): Resource<List<Post>> {
        return postSource.getPostByUserId(userId)
    }
}