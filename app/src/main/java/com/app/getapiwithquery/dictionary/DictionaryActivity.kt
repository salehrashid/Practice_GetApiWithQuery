package com.app.getapiwithquery.dictionary

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.getapiwithquery.databinding.ActivityDictionaryBinding
import com.app.getapiwithquery.dictionary.data.DictionaryResponseItem
import com.app.getapiwithquery.dictionary.network.DictionaryConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DictionaryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDictionaryBinding
    private val adapterResponse = DictionaryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDictionaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getSearch()
    }

    private fun getSearch() {
        binding.svDictionary.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    getDictApi(it)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }

    private fun getDictApi(word: String) {
        DictionaryConfig.getDictionaryService().getDictiory(word)
            .enqueue(object : Callback<ArrayList<DictionaryResponseItem>> {
                override fun onResponse(
                    call: Call<ArrayList<DictionaryResponseItem>>,
                    response: Response<ArrayList<DictionaryResponseItem>>
                ) {
                    response.body()?.let {
                        setRecyclerView(it)
                    }
                }

                override fun onFailure(
                    call: Call<ArrayList<DictionaryResponseItem>>,
                    t: Throwable
                ) {
                    Log.d(TAG, "onFailure: $t")
                }
            })
    }

    private fun setRecyclerView(data: ArrayList<DictionaryResponseItem>) {
        binding.apply {
            tvWord.text = data[0].word
            tvPhonetic.text = data[0].phonetic
        }

        binding.rvDictionary.apply {
            layoutManager = LinearLayoutManager(this@DictionaryActivity)
            adapter = adapterResponse
            adapterResponse.setDictionary(data)
        }
    }
}