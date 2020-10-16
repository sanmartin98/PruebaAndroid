package com.example.pruebaandroid.repositories.photo

import com.example.pruebaandroid.accessdata.config.Resource
import com.example.pruebaandroid.accessdata.photo.PhotoSource
import com.example.pruebaandroid.model.Photo

class RepoPhotoImpl(private val photoSource: PhotoSource):IRepoPhoto {
    override suspend fun getPhotosByAlbumId(albumId: Int): Resource<List<Photo>> {
        return photoSource.getPhotosByAlbumId(albumId)
    }
}