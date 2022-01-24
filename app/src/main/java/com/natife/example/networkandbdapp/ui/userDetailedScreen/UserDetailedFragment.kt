package com.natife.example.networkandbdapp.ui.userDetailedScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.natife.example.networkandbdapp.MyApp
import com.natife.example.networkandbdapp.data.UserRepository
import com.natife.example.networkandbdapp.databinding.UserDetailedFragmentBinding
import javax.inject.Inject

class UserDetailedFragment : Fragment() {

    @Inject
    lateinit var userRepository: UserRepository

    private lateinit var binding: UserDetailedFragmentBinding
//    private val dataBaseRepository: DataBaseRepository by lazy {
//        DataBaseRepository(
//            UserDataBase.getInstance(
//                requireContext()
//            ).userDao
//        )
//    }
//    private val userFetcher: UserFetcher by lazy { UserFetcherImpl() }
//    private val userRepository by lazy {
//        UserRepository(
//            dataBaseRepository,
//            userFetcher
//        )
//    }

    private val detailedViewModelFactory by lazy {
        UserListViewModelFactory(userRepository)
    }

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

        (requireContext().applicationContext as MyApp).appComponent.inject(this)

        detailedViewModel.detailedUser.observe(viewLifecycleOwner, {
            binding.userName.text = it.name
            binding.userLastName.text = it.lastName
            binding.userGender.text = it.userGender
            Glide.with(this).load(it.userPhotoLink).into(binding.userPhoto)
        })
        arguments?.let { detailedViewModel.getUserDetailedInfo(it.getString(KEY_ID).toString()) }
    }

    companion object {

        private const val KEY_ID: String = "user_id"

        fun getUserDetailedFragmentInstance(id: String): UserDetailedFragment {
            return UserDetailedFragment().apply {
                arguments = Bundle().apply {
                    putString(KEY_ID, id)
                }
            }
        }
    }

}