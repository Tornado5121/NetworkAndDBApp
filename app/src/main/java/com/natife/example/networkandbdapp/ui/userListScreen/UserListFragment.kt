package com.natife.example.networkandbdapp.ui.userListScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.natife.example.networkandbdapp.R
import com.natife.example.networkandbdapp.databinding.UserListFragmentBinding
import com.natife.example.networkandbdapp.db.UserDataBase
import com.natife.example.networkandbdapp.repositories.UserRepository
import com.natife.example.networkandbdapp.ui.userDetailedScreen.UserDetailedFragment
import com.natife.example.networkandbdapp.ui.userListScreen.adapters.UserListAdapter

class UserListFragment : Fragment() {

    private lateinit var binding: UserListFragmentBinding
    private val userRepository by lazy { UserRepository(UserDataBase.getInstance(requireContext())) }

    private val userNameAdapter by lazy {
        UserListAdapter {
            requireActivity().supportFragmentManager.beginTransaction()
                .addToBackStack("")
                .replace(
                    R.id.main_activity_fragment_container,
                    UserDetailedFragment.getUserDetailedFragmentInstance(it.id)
                ).commit()
        }
    }

    private val userListViewModelFactory by lazy {
        UserListViewModelFactory(
            userRepository
        )
    }

    private val userListViewModel: UserListViewModel by lazy {
        ViewModelProvider(
            this,
            userListViewModelFactory
        )[UserListViewModel::class.java]
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
        binding.userRecyclerView.layoutManager = LinearLayoutManager(activity)
        binding.userRecyclerView.adapter = userNameAdapter
        binding.gettingUserInfoProgressBar.isVisible = true
        userListViewModel.getUserNameList().observe(
            viewLifecycleOwner,
            { userNameList ->
                userNameAdapter.submitList(userNameList)
                if (userNameList.isNotEmpty()) {
                    binding.gettingUserInfoProgressBar.isVisible = false
                }
            })
    }

}