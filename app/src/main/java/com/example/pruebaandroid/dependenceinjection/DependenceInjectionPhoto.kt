package com.example.pruebaandroid.dependenceinjection

import com.example.pruebaandroid.accessdata.photo.PhotoSource
import com.example.pruebaandroid.repositories.photo.RepoPhotoImpl

class DependenceInjectionPhoto {
    fun getRepoPhoto():RepoPhotoImpl{
        return RepoPhotoImpl(PhotoSource())
    }
}