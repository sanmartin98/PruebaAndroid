package com.example.pruebaandroid.userInterface.viewmodels

import com.example.pruebaandroid.repositories.photo.RepoPhotoImpl
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Observable
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito

class PhotoViewModelTest {
    private val mockRepoPhtoImpl = Mockito.mock(RepoPhotoImpl::class.java)
    private val viewModel = PhotoViewModel(mockRepoPhtoImpl)

    @Test
    fun test_getPhotos(){
        val userId: Int = 1
        viewModel.getPhotosByAlbumId(userId)
        verify(mockRepoPhtoImpl).getPhotosByAlbumId(userId)
    }


    @Test
    fun test_getPhotosEmpty() {
        whenever(mockRepoPhtoImpl.getPhotosByAlbumId(0))
            .thenReturn(Observable.just(listOf()))
        val expected = 0

        val photos = viewModel.getPhotosByAlbumId(0).blockingFirst()

        Assert.assertNotNull(photos)
        Assert.assertEquals(expected, photos.count())
    }
}