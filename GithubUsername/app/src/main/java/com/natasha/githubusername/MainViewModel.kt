package com.natasha.githubusername

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.natasha.githubusername.data.User
import com.natasha.githubusername.repository.UserRepository
import com.natasha.githubusername.repository.UserRepositoryImpl
import com.natasha.githubusername.service.Api
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val userRepository: UserRepository): ViewModel() {
    private val _fullName = MutableLiveData<String>()

    val fullName: LiveData<String>
    get() = _fullName

    fun searchUser(username: String) {
        userRepository.getUser(
            username,
            {user -> _fullName.value = user.name},
            {t -> Log.e("MainActivity", "onFailure: ", t) }
        )
    }
}