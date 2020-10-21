package com.example.pruebaandroid.userInterface.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.pruebaandroid.accessdata.config.Resource
import com.example.pruebaandroid.model.Album
import com.example.pruebaandroid.repositories.album.RepoAlbumImpl
import io.reactivex.Observable
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class AlbumViewModel(private val repoAlbumImpl: RepoAlbumImpl):ViewModel() {

    fun getAlbumByUserId(userId: Int):Observable<List<Album>>{
        return repoAlbumImpl.getAlbumByUserId(userId)
    }

}