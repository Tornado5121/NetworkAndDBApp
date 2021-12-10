package com.natife.example.networkandbdapp.ui.userDetailedScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.natife.example.networkandbdapp.R
import com.natife.example.networkandbdapp.databinding.UserDetailedFragmentBinding

class UserDetailedFragment : Fragment(R.layout.user_detailed_fragment) {

    private lateinit var binding: UserDetailedFragmentBinding
    private val detailedViewModelFactory by lazy { UserListViewModelFactory(requireContext()) }
    private val detailedViewModel by lazy {
        ViewModelProvider(
            this,
            detailedViewModelFactory
        )[UserDetailedViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = UserDetailedFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let { detailedViewModel.getUserDetailedInfo(it.getString(KEY_NAME)) }
        detailedViewModel.detailedUser.observe(viewLifecycleOwner, {
            binding.userName.text = it.name
            binding.userLastName.text = it.lastName
            binding.userGender.text = it.gender
            Glide.with(this).load(it.userPicture).into(binding.userPhoto)
        })
    }

    companion object {
        private const val KEY_NAME: String = "user_name"
        fun getUserDetailedFragmentInstance(name: String?): UserDetailedFragment {
            return UserDetailedFragment().apply {
                arguments = Bundle().apply {
                    putString(KEY_NAME, name)
                }
            }
        }
    }
}