package com.natife.example.networkandbdapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.natife.example.networkandbdapp.R
import com.natife.example.networkandbdapp.databinding.ActivityMainBinding
import com.natife.example.networkandbdapp.ui.userListScreen.UserListFragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val fragment = UserListFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.main_activity_fragment_container, fragment).commit()
    }
}