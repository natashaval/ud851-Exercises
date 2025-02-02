package com.natasha.githubusername

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.natasha.githubusername.repository.UserRepository
import com.natasha.githubusername.service.Api
import java.lang.IllegalArgumentException
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory @Inject constructor(private val userRepository: UserRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(userRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}