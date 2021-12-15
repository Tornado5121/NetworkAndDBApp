package com.natife.example.networkandbdapp.ui.userListScreen.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.natife.example.networkandbdapp.databinding.UserAdapterItemBinding
import com.natife.example.networkandbdapp.db.UserEntity

class UserListAdapter(
    private val onClick: (UserEntity) -> Unit
) : ListAdapter<UserEntity,
        UserListAdapter.ItemViewHolder>(ItemDiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(currentList[position], onClick)
    }

    class ItemViewHolder(private val binding: UserAdapterItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: UserEntity, click: (UserEntity) -> Unit) {
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

    class ItemDiffUtilCallback : DiffUtil.ItemCallback<UserEntity>() {
        override fun areItemsTheSame(oldItem: UserEntity, newItem: UserEntity): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: UserEntity, newItem: UserEntity): Boolean {
            return oldItem == newItem
        }
    }

}