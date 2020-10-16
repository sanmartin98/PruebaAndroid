package com.example.pruebaandroid.accessdata.user

import com.example.pruebaandroid.accessdata.config.Resource
import com.example.pruebaandroid.accessdata.config.RetrofitClient
import com.example.pruebaandroid.model.User

class UserSource {

    suspend fun getUsers(): Resource<List<User>>{
        return Resource.Success(RetrofitClient().getRetroInstance().create(IApiServiceUser::class.java).getUsers())
    }
}