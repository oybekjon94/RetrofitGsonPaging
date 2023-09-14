package com.example.retrofit

import com.google.gson.annotations.SerializedName

data class UserListResponse(
    //Serverdan shu nom bilan keladi
    @SerializedName("data")
    val userList : List<User>,
    val page: Int,
    val per_page: Int,
    val support: Support,
    val total: Int,
    val total_pages: Int
)