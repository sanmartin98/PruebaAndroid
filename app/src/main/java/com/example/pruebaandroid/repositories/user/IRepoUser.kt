package com.example.pruebaandroid.repositories.user

import com.example.pruebaandroid.accessdata.config.Resource
import com.example.pruebaandroid.model.User
import io.reactivex.Observable

interface IRepoUser {

    fun getUsers(): Observable<List<User>>

}