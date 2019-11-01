package com.natasha.githubusername.repository

import com.natasha.githubusername.data.User

interface UserRepository {
    fun getUser(username: String, onSuccess: (user: User) -> Unit, onFailure: (t: Throwable) -> Unit)
}