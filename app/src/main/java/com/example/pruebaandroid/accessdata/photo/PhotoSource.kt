package com.example.pruebaandroid.accessdata.photo


import com.example.pruebaandroid.accessdata.config.Resource
import com.example.pruebaandroid.accessdata.config.RetrofitClient
import com.example.pruebaandroid.model.Photo

class PhotoSource {
    suspend fun getPhotosByAlbumId(albumId:Int): Resource<List<Photo>> {
        return Resource.Success(RetrofitClient().getRetroInstance().create(IApiServicePhoto::class.java).getPhotosByAlbumId(albumId))
    }
}