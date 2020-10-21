package com.example.pruebaandroid.repositories.user

import com.example.pruebaandroid.accessdata.config.Resource
import com.example.pruebaandroid.accessdata.user.UserSource
import com.example.pruebaandroid.model.User
import io.reactivex.Observable

class RepoUserImpl(private val userSource: UserSource): IRepoUser {
    override fun getUsers(): Observable<List<User>> {
        return userSource.getUsers()
    }
}