package com.natife.example.networkandbdapp.ui.userListScreen

import com.natife.example.networkandbdapp.base.BaseViewModel
import com.natife.example.networkandbdapp.base.UseCase

class UserListViewModel(
    UserListReducer: UserListReducer,
    listUseCase: List<UseCase<UserListState,UserListActions>>
) : BaseViewModel<UserListState, UserListActions>(
    UserListReducer,
    listUseCase
) {

    fun getUsers() {
        action(UserListActions.LoadUserData)
    }

    fun addToDbData() {
        action(UserListActions.WriteToDbUserInfo)
    }

    fun displayUserList() {
        action(UserListActions.DisplayUserList)
    }

}