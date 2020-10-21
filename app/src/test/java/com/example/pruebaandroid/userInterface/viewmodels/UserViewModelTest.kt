package com.example.pruebaandroid.userInterface.viewmodels

import com.example.pruebaandroid.repositories.user.RepoUserImpl
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Observable
import org.junit.Assert.*

import org.junit.Test
import org.mockito.Mockito

class UserViewModelTest {
    private val mockRepoUserImpl = Mockito.mock(RepoUserImpl::class.java)
    private val viewModel = UserViewModel(mockRepoUserImpl)

    @Test
    fun test_getUsers(){
        viewModel.getUsers()
        verify(mockRepoUserImpl).getUsers()
    }


    @Test
    fun test_getUsersEmpty() {
        whenever(mockRepoUserImpl.getUsers())
            .thenReturn(Observable.just(listOf()))
        val expected = 0

        val users = viewModel.getUsers().blockingFirst()

        assertNotNull(users)
        assertEquals(expected, users.count())
    }
}