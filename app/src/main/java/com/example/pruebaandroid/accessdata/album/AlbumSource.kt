package com.example.pruebaandroid.accessdata.album

import com.example.pruebaandroid.accessdata.config.RetrofitClient
import com.example.pruebaandroid.model.Album
import io.reactivex.Observable

class AlbumSource {

    fun getAlbumsByUserId(userId: Int): Observable<List<Album>> {
        return RetrofitClient().getRetroInstance().create(IApiServiceAlbum::class.java).getAlbumsByUserId(userId)
    }

}