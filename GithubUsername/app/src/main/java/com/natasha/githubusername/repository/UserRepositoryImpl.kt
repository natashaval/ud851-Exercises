package com.natasha.githubusername.repository

import android.util.Log
import com.natasha.githubusername.data.User
import com.natasha.githubusername.service.Api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepositoryImpl(private val api: Api) : UserRepository {
    override fun getUser(
        username: String,
        onSuccess: (user: User) -> Unit,
        onFailure: (t: Throwable) -> Unit
    ) {
        api.getUser(username).enqueue(object : Callback<User> {
            override fun onFailure(call: Call<User>, t: Throwable) {
                onFailure.invoke(t)
            }

            override fun onResponse(call: Call<User>, response: Response<User>) {
                response.body()?.let { user: User ->
//                    fullName.text = user.name
//                    _fullName.value = user.name
                    onSuccess.invoke(user)
                }
            }

        })
    }

}