package com.example.pruebaandroid.repositories.photo

import com.example.pruebaandroid.accessdata.photo.PhotoSource
import com.example.pruebaandroid.model.Photo
import io.reactivex.Observable

class RepoPhotoImpl(private val photoSource: PhotoSource):IRepoPhoto {
    override fun getPhotosByAlbumId(albumId: Int): Observable<List<Photo>> {
        return photoSource.getPhotosByAlbumId(albumId)
    }
}