package com.natife.example.networkandbdapp.ui.userListScreen

import com.natife.example.networkandbdapp.base.Reducer

class UserListReducer: Reducer<UserListState, UserListActions> {
    override val initialState: UserListState = UserListState()

    override fun reduce(state: UserListState, action: UserListActions): UserListState {
        return when (action) {
            is UserListActions.None -> state
            is UserListActions.LoadingUserData -> state
            is UserListActions.UserDataLoaded -> state
            is UserListActions.Error -> state
        }
    }
}