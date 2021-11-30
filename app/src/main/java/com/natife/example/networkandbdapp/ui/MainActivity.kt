package com.natife.example.networkandbdapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.natife.example.networkandbdapp.R
import com.natife.example.networkandbdapp.api.Requests
import com.natife.example.networkandbdapp.api.RetrofitClient
import com.natife.example.networkandbdapp.databinding.ActivityMainBinding
import com.natife.example.networkandbdapp.models.User
import com.natife.example.networkandbdapp.models.UserArray
import com.natife.example.networkandbdapp.ui.userListScreen.UserListFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        val userListFragment = UserListFragment(this)
        supportFragmentManager.beginTransaction()
            .add(R.id.main_activity_fragment_container, userListFragment).commit()
    }
}