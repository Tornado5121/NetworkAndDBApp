package com.natife.example.networkandbdapp.ui.userListScreen.useCase

import com.natife.example.networkandbdapp.base.UseCase
import com.natife.example.networkandbdapp.ui.userListScreen.UserListActions
import com.natife.example.networkandbdapp.ui.userListScreen.UserListState

class UserListDisplayUseCase: UseCase<UserListState, UserListActions> {
    override fun execute(state: UserListState, action: UserListActions): UserListActions {
        TODO("Not yet implemented")
    }

    override fun canHandle(action: UserListActions): Boolean {
        TODO("Not yet implemented")
    }
}