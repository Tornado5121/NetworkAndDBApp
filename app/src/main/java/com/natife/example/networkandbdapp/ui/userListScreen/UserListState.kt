package com.natife.example.networkandbdapp.ui.userListScreen

import android.widget.ProgressBar
import com.natife.example.networkandbdapp.models.UserArray

data class UserListState(
    val userNameList: List<UserArray>,
    val progressBar: ProgressBar,
    val errorText: String
)