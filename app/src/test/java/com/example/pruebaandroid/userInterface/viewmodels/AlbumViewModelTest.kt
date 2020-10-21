package com.example.pruebaandroid.userInterface.viewmodels

import com.example.pruebaandroid.repositories.album.RepoAlbumImpl
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Observable
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito

class AlbumViewModelTest {
    private val mockRepoAlbumImpl = Mockito.mock(RepoAlbumImpl::class.java)
    private val viewModel = AlbumViewModel(mockRepoAlbumImpl)

    @Test
    fun test_getAlbums(){
        val userId: Int = 1
        viewModel.getAlbumByUserId(userId)
        verify(mockRepoAlbumImpl).getAlbumByUserId(userId)
    }


    @Test
    fun test_getAlbumsEmpty() {
        whenever(mockRepoAlbumImpl.getAlbumByUserId(0))
            .thenReturn(Observable.just(listOf()))
        val expected = 0

        val albums = viewModel.getAlbumByUserId(0).blockingFirst()

        Assert.assertNotNull(albums)
        Assert.assertEquals(expected, albums.count())
    }
}