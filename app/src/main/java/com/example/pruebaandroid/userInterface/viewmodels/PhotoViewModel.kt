package com.example.pruebaandroid.userInterface.viewmodels

import androidx.lifecycle.ViewModel
import com.example.pruebaandroid.model.Photo
import com.example.pruebaandroid.repositories.photo.RepoPhotoImpl
import io.reactivex.Observable

class PhotoViewModel(private val repoPhoto: RepoPhotoImpl):ViewModel() {

    fun getPhotosByAlbumId(albumId: Int):Observable<List<Photo>>{
        return repoPhoto.getPhotosByAlbumId(albumId)
    }

}