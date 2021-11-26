package com.natife.example.networkandbdapp.ui.userListScreen

import com.natife.example.networkandbdapp.base.BaseViewModel
import com.natife.example.networkandbdapp.ui.userListScreen.useCase.UserListDisplayUseCase

class UserListViewModel(
    UserListReducer: UserListReducer,
    UserListDisplayUseCase: List<UserListDisplayUseCase>
) : BaseViewModel<UserListState, UserListActions>(
    UserListReducer,
    UserListDisplayUseCase
) {
}