package com.natife.example.networkandbdapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.natife.example.networkandbdapp.R
import com.natife.example.networkandbdapp.api.RetrofitClient
import com.natife.example.networkandbdapp.databinding.ActivityMainBinding
import com.natife.example.networkandbdapp.db.UserDataBase
import com.natife.example.networkandbdapp.repositories.UserRepository
import com.natife.example.networkandbdapp.ui.userListScreen.UserListFragment

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        if (supportFragmentManager.fragments.isEmpty()) {
            val fragment = UserListFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.main_activity_fragment_container, fragment).commit()


            val userRepository =
                UserRepository(
                    UserDataBase.getInstance(applicationContext).userDao,
                    RetrofitClient.api
                )

            val mainActivityVieModel = MainActivityViewModel(userRepository)

            mainActivityVieModel.clearDb()
        }
    }
}