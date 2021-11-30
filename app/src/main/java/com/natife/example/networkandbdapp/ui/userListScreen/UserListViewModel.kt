package com.natife.example.networkandbdapp.ui.userListScreen

import com.natife.example.networkandbdapp.base.BaseViewModel
import com.natife.example.networkandbdapp.base.UseCase
import com.natife.example.networkandbdapp.ui.userListScreen.useCase.UserListDisplayUseCase

class UserListViewModel(
    UserListReducer: UserListReducer,
    listUseCase: List<UseCase<UserListState,UserListActions>>
) : BaseViewModel<UserListState, UserListActions>(
    UserListReducer,
    listUseCase
) {

    fun getUsers() {
        action(UserListActions.LoadingUserData)
    }

}