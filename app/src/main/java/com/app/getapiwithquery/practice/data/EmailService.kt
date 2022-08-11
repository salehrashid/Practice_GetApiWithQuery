package com.app.getapiwithquery.practice.data

import com.app.getapiwithquery.practice.network.ApiFakeItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface EmailService {
    @GET("comments")
    fun getSearchEmail(
        @Query("postId")
        id: String
    ): Call<List<ApiFakeItem>>
}