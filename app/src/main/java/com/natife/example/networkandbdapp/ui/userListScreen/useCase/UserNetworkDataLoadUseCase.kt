package com.natife.example.networkandbdapp.ui.userListScreen.useCase

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

class UserNetworkDataLoadUseCase : UseCase<UserListState, UserListActions> {

    private var userList = listOf<User>()

    override fun execute(state: UserListState, action: UserListActions): UserListActions {
        return if (action is UserListActions.LoadUserData) {
            loadUserDataFromNetwork()
            UserListActions.UserDataLoaded(userList)
        } else {
            UserListActions.None
        }
    }

    override fun canHandle(action: UserListActions): Boolean {
        return action is UserListActions.LoadUserData
    }

    private fun loadUserDataFromNetwork() {
        val retrofit = RetrofitClient.getInstance()?.create(Requests::class.java)
        val call = retrofit?.getUserInfo(10)
        call?.enqueue(object : Callback<UserArray> {
            override fun onResponse(call: Call<UserArray>, response: Response<UserArray>) {
                userList = response.body()?.userArray ?: emptyList()
            }

            override fun onFailure(call: Call<UserArray>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}