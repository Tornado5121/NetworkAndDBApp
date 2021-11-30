package com.natife.example.networkandbdapp.ui.userListScreen.useCase

import com.natife.example.networkandbdapp.base.UseCase
import com.natife.example.networkandbdapp.ui.userListScreen.UserListActions
import com.natife.example.networkandbdapp.ui.userListScreen.UserListState

class UserListAddingDataToDbUseCase : UseCase<UserListState,UserListActions> {
    override fun execute(state: UserListState, action: UserListActions): UserListActions {
        return if (action is UserListActions.WriteToDbUserInfo) {
            UserListActions.UserInfoAddedToDB()
        } else {
            UserListActions.None
        }
    }

    override fun canHandle(action: UserListActions): Boolean {
        return action is UserListActions.WriteToDbUserInfo
    }
}