package com.example.retrofit

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * internetdan kelayotgan malumotni aniq joyini korsatishimiz kere boladi
 * sen todolarni u yerda userlarni uyoqdan deb
 * bunda biz interface qilishimiz kere
 */
interface ApiInterface {
    @GET("/todos")
    //response qanaqa turda malumot kelsa ushani olib olamiz
    suspend fun getTodoList():Response<List<Todo>>

    //Serverdan qaysi pagedan malumot olganligini suraydi
    @GET("/api/users")
    suspend fun getAllUserByPage(@Query("page") page:Int,@Query("per_page")perPage:Int):Response<UserListResponse>

    //endi notFoundni korib chiqamiz yani 404
    @GET("/api/users/{id}")
    suspend fun getUserByID(@Path("id")userId:Int):Response<UserResponse>

    //bu malumot turi post
    @POST("/api/users")
    suspend fun createUser(@Body userCreate:UserCreate):Response<UserCreate>

    //ochirish uchun
    @DELETE("/api/users/{id}")
    suspend fun deleteUser(@Path("id")userId: Int):Response<User>


}