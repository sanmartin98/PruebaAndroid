package com.example.pruebaandroid.userInterface.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.pruebaandroid.accessdata.config.Resource
import com.example.pruebaandroid.repositories.photo.RepoPhotoImpl
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class PhotoViewModel(private val repoPhoto: RepoPhotoImpl):ViewModel() {

    fun fetchPhotosUserList(albumId:Int) = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(repoPhoto.getPhotosByAlbumId(albumId))
        } catch (e:Exception){
            emit(Resource.Failure(e))
        }
    }

}