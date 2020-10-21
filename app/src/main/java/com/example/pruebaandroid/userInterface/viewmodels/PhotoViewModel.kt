package com.example.pruebaandroid.userInterface.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.pruebaandroid.accessdata.config.Resource
import com.example.pruebaandroid.model.Album
import com.example.pruebaandroid.model.Photo
import com.example.pruebaandroid.repositories.photo.RepoPhotoImpl
import io.reactivex.Observable
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class PhotoViewModel(private val repoPhoto: RepoPhotoImpl):ViewModel() {

    fun getPhotosByAlbumId(albumId: Int):Observable<List<Photo>>{
        return repoPhoto.getPhotosByAlbumId(albumId)
    }

}