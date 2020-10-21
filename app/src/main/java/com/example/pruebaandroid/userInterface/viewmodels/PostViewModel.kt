package com.example.pruebaandroid.userInterface.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.pruebaandroid.accessdata.config.Resource
import com.example.pruebaandroid.model.Post
import com.example.pruebaandroid.model.User
import com.example.pruebaandroid.repositories.post.RepoPostImpl
import io.reactivex.Observable
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class PostViewModel(private val repoPostImpl: RepoPostImpl):ViewModel() {

    fun getPostByUserId(userId: Int):Observable<List<Post>>{
        return repoPostImpl.getPostByUserId(userId)
    }

}