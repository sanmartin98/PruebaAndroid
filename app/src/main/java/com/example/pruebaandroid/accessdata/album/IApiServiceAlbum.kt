package com.example.pruebaandroid.accessdata.album

import com.example.pruebaandroid.constants.WS_GET_ALBUMS
import com.example.pruebaandroid.model.Album
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface IApiServiceAlbum {

    @GET(WS_GET_ALBUMS)
    fun getAlbumsByUserId(@Query("userId") userId:Int): Observable<List<Album>>

}