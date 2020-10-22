package com.example.pruebaandroid.userInterface.viewmodels

import androidx.lifecycle.ViewModel
import com.example.pruebaandroid.model.User
import com.example.pruebaandroid.repositories.user.RepoUserImpl
import io.reactivex.Observable

class UserViewModel(private val repoUserImpl: RepoUserImpl): ViewModel() {

    fun getUsers():Observable<List<User>>{
        return repoUserImpl.getUsers()
    }

}