package com.example.pruebaandroid.repositories.photo

import com.example.pruebaandroid.accessdata.config.Resource
import com.example.pruebaandroid.model.Photo

interface IRepoPhoto {
    suspend fun getPhotosByAlbumId(albumId: Int):Resource<List<Photo>>
}