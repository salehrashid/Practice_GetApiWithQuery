package com.app.getapiwithquery.dictionary.network

import com.app.getapiwithquery.dictionary.data.DictionaryResponseItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DictionaryService {
    @GET("{word}")
    fun getDictiory(
        @Path("word")
        word: String
    ): Call<ArrayList<DictionaryResponseItem>>
}