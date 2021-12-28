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

    companion object {
        var isFirstRequest = true
    }

    private val mainActivityVieModel by lazy { MainActivityViewModel(userRepository) }

    private val userRepository by lazy {
        UserRepository(
            UserDataBase.getInstance(applicationContext).userDao,
            RetrofitClient.api
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        if (supportFragmentManager.fragments.isEmpty()) {
            val fragment = UserListFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.main_activity_fragment_container, fragment).commit()
        }
        clearDB()
    }

    private fun clearDB() {
        mainActivityVieModel.clearDbForFirstLaunchAfterNoInternet()
    }

}