package com.app.getapiwithquery.practice

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.getapiwithquery.practice.data.EmailConfig
import com.app.getapiwithquery.practice.network.ApiFakeItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiViewModel: ViewModel() {
    private val listUser = MutableLiveData<List<ApiFakeItem>>()

    fun searchUserApi(id: String){
        EmailConfig.getApiService().getSearchEmail(id).enqueue(object : Callback<List<ApiFakeItem>> {
            override fun onResponse(call: Call<List<ApiFakeItem>>, response: Response<List<ApiFakeItem>>) {
                listUser.value = response.body()
            }

            override fun onFailure(call: Call<List<ApiFakeItem>>, t: Throwable) {
                Log.d(TAG, "onFailure: $t")
            }
        })
    }
    fun getSearchUser(): LiveData<List<ApiFakeItem>> = listUser
}