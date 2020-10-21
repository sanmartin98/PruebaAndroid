package com.example.pruebaandroid.repositories.album

import com.example.pruebaandroid.accessdata.config.Resource
import com.example.pruebaandroid.model.Album
import io.reactivex.Observable

interface IRepoAlbum {

    fun getAlbumByUserId(userId:Int):Observable<List<Album>>

}