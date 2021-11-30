package com.natife.example.networkandbdapp.ui.userListScreen.useCase

import android.content.Context
import android.widget.Toast
import com.natife.example.networkandbdapp.api.Requests
import com.natife.example.networkandbdapp.api.RetrofitClient
import com.natife.example.networkandbdapp.base.UseCase
import com.natife.example.networkandbdapp.models.User
import com.natife.example.networkandbdapp.models.UserArray
import com.natife.example.networkandbdapp.ui.userListScreen.UserListActions
import com.natife.example.networkandbdapp.ui.userListScreen.UserListState
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserDataLoadUseCase() : UseCase<UserListState, UserListActions> {

    private var userList = ArrayList<UserArray>()

    override fun execute(state: UserListState, action: UserListActions): UserListActions {
         if (action is UserListActions.LoadingUserData) {
             loadUserDataFromNetwork()
             return UserListActions.None
        } else {
            return UserListActions.None
        }
    }

    override fun canHandle(action: UserListActions): Boolean {
        return action is UserListActions.LoadingUserData
    }

    private fun loadUserDataFromNetwork() {
        val retrofit = RetrofitClient.getInstance()?.create(Requests::class.java)
        val call = retrofit?.getUserInfo(10)
        call?.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                TODO("Not yet implemented")
            }


        })
    }
}