package com.natasha.githubusername.service

import com.natasha.githubusername.data.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Api {
    @GET("/users/{user}")
    fun getUser(@Path("user") user: String) : Call<User>
}