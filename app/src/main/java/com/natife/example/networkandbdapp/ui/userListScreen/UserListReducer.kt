package com.natife.example.networkandbdapp.ui.userListScreen

import android.content.Context
import android.widget.ProgressBar
import com.natife.example.networkandbdapp.base.Reducer

class UserListReducer(context: Context): Reducer<UserListState, UserListActions> {
    override val initialState: UserListState = UserListState(emptyList(),progressBar = ProgressBar(context), "")

    override fun reduce(state: UserListState, action: UserListActions): UserListState {
        return when (action) {
            is UserListActions.None -> state
            is UserListActions.LoadUserData -> state
            is UserListActions.UserDataLoaded -> state
            is UserListActions.Error -> state
            UserListActions.DisplayUserList -> state
            is UserListActions.UserInfoAddedToDB -> state
            is UserListActions.UserListDisplayed -> state
            UserListActions.WriteToDbUserInfo -> state
        }
    }
}