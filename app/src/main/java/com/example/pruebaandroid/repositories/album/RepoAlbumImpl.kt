package com.example.pruebaandroid.repositories.album

import com.example.pruebaandroid.accessdata.album.AlbumSource
import com.example.pruebaandroid.accessdata.config.Resource
import com.example.pruebaandroid.model.Album

class RepoAlbumImpl(private val albumSource: AlbumSource):IRepoAlbum {
    override suspend fun getAlbumByUserId(userId: Int): Resource<List<Album>> {
        return albumSource.getAlbumsByUserId(userId)
    }
}