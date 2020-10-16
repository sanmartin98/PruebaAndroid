package com.example.pruebaandroid.userInterface.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.pruebaandroid.accessdata.config.Resource
import com.example.pruebaandroid.repositories.user.RepoUserImpl
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class UserViewModel(private val repoUserImpl: RepoUserImpl): ViewModel() {

    val fetchUserList = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(repoUserImpl.getUsers())
        } catch (e:Exception){
            emit(Resource.Failure(e))
        }
    }

}