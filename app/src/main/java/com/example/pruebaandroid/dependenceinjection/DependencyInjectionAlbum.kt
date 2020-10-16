package com.example.pruebaandroid.dependenceinjection

import com.example.pruebaandroid.accessdata.album.AlbumSource
import com.example.pruebaandroid.repositories.album.RepoAlbumImpl

class DependencyInjectionAlbum {

    fun getRepoAlbum():RepoAlbumImpl{
        return RepoAlbumImpl(AlbumSource())
    }

}