package com.example.pruebaandroid.accessdata.user

import com.example.pruebaandroid.accessdata.config.RetrofitClient
import com.example.pruebaandroid.model.User
import io.reactivex.Observable

class UserSource {

    fun getUsers(): Observable<List<User>>{
        return RetrofitClient().getRetroInstance().create(IApiServiceUser::class.java).getUsers()
    }
}