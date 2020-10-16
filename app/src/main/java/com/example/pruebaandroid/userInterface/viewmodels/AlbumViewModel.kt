package com.example.pruebaandroid.userInterface.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.pruebaandroid.accessdata.config.Resource
import com.example.pruebaandroid.repositories.album.RepoAlbumImpl
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class AlbumViewModel(private val repoAlbumImpl: RepoAlbumImpl):ViewModel() {

    fun fetchAlbumsUserList(userId:Int) = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(repoAlbumImpl.getAlbumByUserId(userId))
        }catch (e:Exception){
            emit(Resource.Failure(e))
        }
    }

}