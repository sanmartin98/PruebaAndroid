package com.example.pruebaandroid.repositories.user

import com.example.pruebaandroid.accessdata.config.Resource
import com.example.pruebaandroid.model.User

interface IRepoUser {

    suspend fun getUsers(): Resource<List<User>>

}