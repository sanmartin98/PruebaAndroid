package com.example.pruebaandroid.userInterface.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.pruebaandroid.accessdata.config.Resource
import com.example.pruebaandroid.model.User
import com.example.pruebaandroid.repositories.user.RepoUserImpl
import io.reactivex.Observable
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class UserViewModel(private val repoUserImpl: RepoUserImpl): ViewModel() {

    /*val fetchUserList = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(repoUserImpl.getUsers())
        } catch (e:Exception){
            emit(Resource.Failure(e))
        }
    }*/

    fun getUsers():Observable<List<User>>{
        return repoUserImpl.getUsers()
    }

}