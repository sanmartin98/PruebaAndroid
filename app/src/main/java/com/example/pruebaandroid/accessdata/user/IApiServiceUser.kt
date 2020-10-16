package com.example.pruebaandroid.accessdata.user

import com.example.pruebaandroid.constants.WS_GET_USERS
import com.example.pruebaandroid.model.User
import retrofit2.http.GET

interface IApiServiceUser {

    @GET(WS_GET_USERS)
    suspend fun getUsers(): List<User>

}