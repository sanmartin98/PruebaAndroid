package com.example.pruebaandroid.userInterface.viewmodels

import androidx.lifecycle.ViewModel
import com.example.pruebaandroid.model.Post
import com.example.pruebaandroid.repositories.post.RepoPostImpl
import io.reactivex.Observable

class PostViewModel(private val repoPostImpl: RepoPostImpl):ViewModel() {

    fun getPostByUserId(userId: Int):Observable<List<Post>>{
        return repoPostImpl.getPostByUserId(userId)
    }

}