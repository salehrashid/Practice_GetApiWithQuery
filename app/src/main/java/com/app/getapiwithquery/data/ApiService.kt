package com.app.getapiwithquery.data

import com.app.getapiwithquery.network.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("search/users")
    fun searchUser(@Query("q")username: String): Call<UserResponse>
}