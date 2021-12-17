package com.natife.example.networkandbdapp.ui.userListScreen.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.natife.example.networkandbdapp.databinding.UserAdapterItemBinding
import com.natife.example.networkandbdapp.domain.DomainUser

class UserListAdapter(
    private val onClick: (DomainUser) -> Unit
) : ListAdapter<DomainUser,
        UserListAdapter.ItemViewHolder>(ItemDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(currentList[position], onClick)
    }

    class ItemViewHolder(private val binding: UserAdapterItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: DomainUser, click: (DomainUser) -> Unit) {
            with(binding) {
                userNameView.text = data.name
                root.setOnClickListener {
                    click(data)
                }
            }
        }

        companion object {
            fun from(parent: ViewGroup): ItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = UserAdapterItemBinding
                    .inflate(layoutInflater, parent, false)
                return ItemViewHolder(binding)
            }
        }
    }

    class ItemDiffUtilCallback : DiffUtil.ItemCallback<DomainUser>() {
        override fun areItemsTheSame(oldItem: DomainUser, newItem: DomainUser): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: DomainUser, newItem: DomainUser): Boolean {
            return oldItem == newItem
        }
    }

}