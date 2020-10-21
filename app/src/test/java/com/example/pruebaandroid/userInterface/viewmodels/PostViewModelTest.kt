package com.example.pruebaandroid.userInterface.viewmodels

import com.example.pruebaandroid.repositories.post.RepoPostImpl
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Observable
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull

import org.junit.Test
import org.mockito.Mockito

class PostViewModelTest {
    private val mockRepoPostImpl = Mockito.mock(RepoPostImpl::class.java)
    private val viewModel = PostViewModel(mockRepoPostImpl)

    @Test
    fun test_getPosts(){
        val userId: Int = 1
        viewModel.getPostByUserId(userId)
        verify(mockRepoPostImpl).getPostByUserId(userId)
    }


    @Test
    fun test_getPostsEmpty() {
        whenever(mockRepoPostImpl.getPostByUserId(0))
            .thenReturn(Observable.just(listOf()))
        val expected = 0

        val posts = viewModel.getPostByUserId(0).blockingFirst()

        assertNotNull(posts)
        assertEquals(expected, posts.count())
    }
}