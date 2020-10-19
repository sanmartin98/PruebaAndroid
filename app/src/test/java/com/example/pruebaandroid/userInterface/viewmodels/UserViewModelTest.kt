package com.example.pruebaandroid.userInterface.viewmodels

import com.example.pruebaandroid.accessdata.config.Resource
import com.example.pruebaandroid.model.User
import com.example.pruebaandroid.repositories.user.RepoUserImpl
import com.example.pruebaandroid.userInterface.viewmodels.UserViewModel
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before

import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

@ExperimentalCoroutinesApi
class UserViewModelTest {
    @get:Rule
    val exceptionRule: ExpectedException = ExpectedException.none()

    val testDispatcher = TestCoroutineDispatcher()

    /*
    @Before
    fun setUp(){
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun tearDown(){
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }*/

    @Test
    suspend fun test_getUsersEmpty() = runBlockingTest{
        val repository: RepoUserImpl = mock()
        whenever(repository.getUsers())
            .thenReturn(Resource.Success(listOf()))
        val expected = 0
        val model = UserViewModel(repository)

        val users = model.fetchUserList.value as List<User>

        assertNotNull(users)
        assertEquals(expected, users.size)
    }

    /*@Test
    suspend fun test_getUsers(){
        val repo: RepoUserImpl = mock()
        whenever(repo.getUsers())
            .thenReturn(
                Resource.Success(
                    listOf(
                        User(1,"camilo","123","a@b"),
                        User(2,"pedro","123","a@b"),
                        User(3,"pablo","123","a@b")
                    )
                )
            )
        val expected = 3
        val model = UserViewModel(repo)

        val users = model.fetchUserList.value as List<User>

        assertNotNull(users)
        assertEquals(expected, users.size)
    }*/
}