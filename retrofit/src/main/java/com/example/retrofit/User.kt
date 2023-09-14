package com.example.retrofit

data class User(
    val avatar: String,
    val email: String,
    val first_name: String,
    val id: Int,
    val last_name: String
)
//name xamda lastname bitta olish uchun extencion qilamiz
{
    fun getFullName() = "$first_name $last_name"
}