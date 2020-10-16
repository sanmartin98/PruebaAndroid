package com.example.pruebaandroid.userInterface.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.pruebaandroid.accessdata.config.Resource
import com.example.pruebaandroid.repositories.post.RepoPostImpl
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class PostViewModel(private val repoPostImpl: RepoPostImpl):ViewModel() {

    fun fetchPostUserList(userId: Int) = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(repoPostImpl.getRepoByUserId(userId))
        } catch (e:Exception){
            emit(Resource.Failure(e))
        }
    }

}