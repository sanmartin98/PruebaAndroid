package com.example.pruebaandroid.repositories.photo

import com.example.pruebaandroid.accessdata.config.Resource
import com.example.pruebaandroid.model.Photo
import io.reactivex.Observable

interface IRepoPhoto {
    fun getPhotosByAlbumId(albumId: Int):Observable<List<Photo>>
}