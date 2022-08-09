package com.app.getapiwithquery.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.content.ContentValues.TAG
import androidx.lifecycle.ViewModelProvider
import com.app.getapiwithquery.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val usernameGit = "saleh"
        val viewModel = ViewModelProvider(this)[UserViewModel::class.java]

        viewModel.searchUserApi(usernameGit)
        viewModel.getSearchUser().observe(this){
            Log.d(TAG, "onCreate: $it")

            println("nama saya ${it.items?.first()?.login}")
        }
    }
}