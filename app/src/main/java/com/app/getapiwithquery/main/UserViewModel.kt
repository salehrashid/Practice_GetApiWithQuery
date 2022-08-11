package com.app.getapiwithquery.main

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.getapiwithquery.main.data.ApiConfig
import com.app.getapiwithquery.main.network.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel : ViewModel() {
    private val listUser = MutableLiveData<UserResponse>()

    //fungsi untuk search
    fun searchUserApi(username: String) {
        ApiConfig.getApiService().searchUser(username).enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                listUser.value = response.body()
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Log.d(TAG, "onFailure: $t")
            }
        })
    }

    //fungsi untuk menampilkan data nya
    fun getSearchUser(): LiveData<UserResponse> = listUser
}