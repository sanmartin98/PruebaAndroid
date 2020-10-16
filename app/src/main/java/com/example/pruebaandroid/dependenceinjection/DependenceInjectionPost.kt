package com.example.pruebaandroid.dependenceinjection

import com.example.pruebaandroid.accessdata.post.PostSource
import com.example.pruebaandroid.repositories.post.RepoPostImpl

class DependenceInjectionPost {

    fun getRepoPost(): RepoPostImpl{
        return RepoPostImpl(PostSource())
    }

}