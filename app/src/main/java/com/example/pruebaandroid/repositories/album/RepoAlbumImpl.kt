package com.example.pruebaandroid.repositories.album

import com.example.pruebaandroid.accessdata.album.AlbumSource
import com.example.pruebaandroid.model.Album
import io.reactivex.Observable

class RepoAlbumImpl(private val albumSource: AlbumSource):IRepoAlbum {
    override fun getAlbumByUserId(userId: Int): Observable<List<Album>> {
        return albumSource.getAlbumsByUserId(userId)
    }
}