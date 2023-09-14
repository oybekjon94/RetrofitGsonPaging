package com.example.retrofit

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("data")
    val user:User
)
