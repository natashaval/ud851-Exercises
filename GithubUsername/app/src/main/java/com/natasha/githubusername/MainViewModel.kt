package com.natasha.githubusername

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.natasha.githubusername.data.User
import com.natasha.githubusername.service.Api
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val api: Api): ViewModel() {
    private val _fullName = MutableLiveData<String>()

    val fullName: LiveData<String>
    get() = _fullName

    fun searchUser(username: String) {
        api.getUser(username).enqueue(object : Callback<User> {
            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.e("MainActivity", "onFailure: ", t)
            }

            override fun onResponse(call: Call<User>, response: Response<User>) {
                response.body()?.let { user: User ->
//                    fullName.text = user.name
                    _fullName.value = user.name
                }
            }

        })
    }
}