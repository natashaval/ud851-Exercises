package com.natasha.githubusername.data

import com.google.gson.annotations.SerializedName

data class User (
    @SerializedName("name")
    val name: String
)