package com.app.getapiwithquery.practice

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.getapiwithquery.databinding.ActivityPracticeBinding
import com.app.getapiwithquery.practice.data.EmailConfig
import com.app.getapiwithquery.practice.network.ApiFakeItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PracticeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPracticeBinding
    private val adapterUser = EmailAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPracticeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getSearch()

        val usernameId = ""
        val viewModel = ViewModelProvider(this)[ApiViewModel::class.java]

        viewModel.searchUserApi(usernameId)
        viewModel.getSearchUser().observe(this) {
            Log.d(TAG, "onCreate: $it")

            setupRecyclerView(it as ArrayList<ApiFakeItem>)
        }
    }

    private fun getSearch() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    getEmailApi(it)
                }
                return true
            }

            override fun onQueryTextChange(query: String?): Boolean {
                return false
            }
        })
    }

    private fun getEmailApi(email: String) {
        EmailConfig.getApiService().getSearchEmail(email)
            .enqueue(object : Callback<List<ApiFakeItem>> {
                override fun onResponse(
                    call: Call<List<ApiFakeItem>>,
                    response: Response<List<ApiFakeItem>>
                ) {
                    response.body()?.let {
                        setupRecyclerView(it as ArrayList<ApiFakeItem>)
                    }
                }

                override fun onFailure(call: Call<List<ApiFakeItem>>, t: Throwable) {
                    Log.d(TAG, "onFailure: $t")
                }
            })
    }

    private fun setupRecyclerView(data: ArrayList<ApiFakeItem>) {
        binding.rvEmail.apply {
            layoutManager = LinearLayoutManager(this@PracticeActivity)
            adapter = adapterUser
            adapterUser.setEmail(data)
        }
    }
}