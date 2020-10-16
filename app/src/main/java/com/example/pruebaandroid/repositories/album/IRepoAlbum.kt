package com.example.pruebaandroid.repositories.album

import com.example.pruebaandroid.accessdata.config.Resource
import com.example.pruebaandroid.model.Album

interface IRepoAlbum {

    suspend fun getAlbumByUserId(userId:Int):Resource<List<Album>>

}