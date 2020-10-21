package com.example.pruebaandroid.accessdata.photo


import com.example.pruebaandroid.accessdata.config.Resource
import com.example.pruebaandroid.accessdata.config.RetrofitClient
import com.example.pruebaandroid.model.Photo
import io.reactivex.Observable

class PhotoSource {
    fun getPhotosByAlbumId(albumId:Int): Observable<List<Photo>> {
        return RetrofitClient().getRetroInstance().create(IApiServicePhoto::class.java).getPhotosByAlbumId(albumId)
    }
}