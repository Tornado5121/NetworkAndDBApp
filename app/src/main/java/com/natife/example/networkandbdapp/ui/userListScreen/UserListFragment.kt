package com.natife.example.networkandbdapp.ui.userListScreen

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.natife.example.networkandbdapp.R
import com.natife.example.networkandbdapp.api.Requests
import com.natife.example.networkandbdapp.api.RetrofitClient
import com.natife.example.networkandbdapp.databinding.UserListFragmentBinding
import com.natife.example.networkandbdapp.models.User
import com.natife.example.networkandbdapp.models.UserArray
import com.natife.example.networkandbdapp.ui.userListScreen.useCase.UserNetworkDataLoadUseCase
import com.natife.example.networkandbdapp.ui.userListScreen.useCase.UserListDisplayUseCase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserListFragment(context: Context) : Fragment(R.layout.user_list_fragment) {

    lateinit var binding: UserListFragmentBinding
    val userNameList = ArrayList<String>()
    val userAdapter = ArrayAdapter(context, android.R.layout.simple_spinner_item, userNameList)
    val reducer: UserListReducer by lazy { UserListReducer() }
    val loadUseCase by lazy { UserNetworkDataLoadUseCase() }
    val displayUserUseCase by lazy { UserListDisplayUseCase() }

    private val itemListViewModel: UserListViewModel by lazy {
        ViewModelProvider(viewModelStore, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return UserListViewModel(
                    reducer,
                    listOf(loadUseCase, displayUserUseCase)
                ) as T
            }
        }).get(UserListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = UserListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.userRecyclerView.adapter = userAdapter
        userNameList.add("hello")
        userNameList.add("hello")
        userNameList.add("hello")
        userNameList.add("hello")
        userNameList.add("hello")



    }

//        binding.userRecyclerView.setOnItemClickListener { parent, view, position, id ->
//            val element = userAdapter.itemAtPosition(position) // The item that was clicked
//
//            val userDetailedFragment = UserDetailedFragment()
//
//            requireActivity().supportFragmentManager.beginTransaction()
//                .replace(R.id.main_activity_fragment_container, UserDetailedFragment.newInstance(view.id)).commit()
    }
