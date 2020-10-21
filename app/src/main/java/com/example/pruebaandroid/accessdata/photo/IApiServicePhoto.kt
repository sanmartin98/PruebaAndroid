package com.example.pruebaandroid.accessdata.photo

import com.example.pruebaandroid.constants.WS_GET_PHOTOS
import com.example.pruebaandroid.model.Photo
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface IApiServicePhoto {
    @GET(WS_GET_PHOTOS)
    fun getPhotosByAlbumId(@Query("albumId") albumId:Int ):Observable<List<Photo>>
}