package com.example.pruebaandroid.userInterface.viewmodels

import androidx.lifecycle.ViewModel
import com.example.pruebaandroid.model.Album
import com.example.pruebaandroid.repositories.album.RepoAlbumImpl
import io.reactivex.Observable

class AlbumViewModel(private val repoAlbumImpl: RepoAlbumImpl):ViewModel() {

    fun getAlbumByUserId(userId: Int):Observable<List<Album>>{
        return repoAlbumImpl.getAlbumByUserId(userId)
    }

}