package com.example.pruebaandroid.accessdata.album

import com.example.pruebaandroid.accessdata.config.Resource
import com.example.pruebaandroid.accessdata.config.RetrofitClient
import com.example.pruebaandroid.model.Album

class AlbumSource {

    suspend fun getAlbumsByUserId(userId: Int): Resource.Success<List<Album>> {
        return Resource.Success(RetrofitClient().getRetroInstance().create(IApiServiceAlbum::class.java).getAlbumsByUserId(userId))
    }

}