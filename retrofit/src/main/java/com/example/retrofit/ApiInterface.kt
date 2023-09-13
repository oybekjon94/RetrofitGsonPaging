package com.example.retrofit

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET

/**
 * internetdan kelayotgan malumotni aniq joyini korsatishimiz kere boladi
 * sen todolarni u yerda userlarni uyoqdan deb
 * bunda biz interface qilishimiz kere
 */
interface ApiInterface {
    @GET("/todos")
    //response qanaqa turda malumot kelsa ushani olib olamiz
    suspend fun getTodoList():Response<List<Todo>>
}