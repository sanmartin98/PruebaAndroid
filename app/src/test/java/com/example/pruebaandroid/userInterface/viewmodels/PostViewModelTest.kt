package com.example.pruebaandroid.userInterface.viewmodels

import com.example.pruebaandroid.accessdata.config.Resource
import com.example.pruebaandroid.model.Post
import com.example.pruebaandroid.model.User
import com.example.pruebaandroid.repositories.post.RepoPostImpl
import com.example.pruebaandroid.repositories.user.RepoUserImpl
import com.example.pruebaandroid.userInterface.viewmodels.UserViewModel
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull

import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

class PostViewModelTest {
    @get:Rule
    val exceptionRule = ExpectedException.none()

    @Test
    suspend fun test_getPosts(){
        val userId = 1
        val repo: RepoPostImpl = mock()
        whenever(repo.getPostByUserId(userId))
            .thenReturn(
                Resource.Success(
                    listOf(
                        Post(userId, 1, "post", "body"),
                        Post(userId, 2, "post", "body"),
                        Post(userId, 3, "post", "body")
                    )
                )
            )
        val expected = 3
        val model = PostViewModel(repo)

        val users = model.fetchPostUserList(userId).value as List<User>

        assertNotNull(users)
        assertEquals(expected, 3)
    }
}