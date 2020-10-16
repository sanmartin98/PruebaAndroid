package com.example.pruebaandroid.dependenceinjection

import com.example.pruebaandroid.accessdata.user.UserSource
import com.example.pruebaandroid.repositories.user.RepoUserImpl

class DependencyInjectionUser {
    fun getRepoUser(): RepoUserImpl{
        return RepoUserImpl(UserSource())
    }
}