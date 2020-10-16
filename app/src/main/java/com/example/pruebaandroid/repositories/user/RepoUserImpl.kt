package com.example.pruebaandroid.repositories.user

import com.example.pruebaandroid.accessdata.config.Resource
import com.example.pruebaandroid.accessdata.user.UserSource
import com.example.pruebaandroid.model.User

class RepoUserImpl(private val userSource: UserSource): IRepoUser {
    override suspend fun getUsers(): Resource<List<User>> {
        return userSource.getUsers()
    }
}