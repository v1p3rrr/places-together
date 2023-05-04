package com.vpr.places_together.ui.friends_screen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vpr.places_together.R

class FriendsAdapter(private val onItemClick: (id: String) -> Long) : //todo change to onItemClick: (id: Long) -> Long)
    ListAdapter<String, FriendsAdapter.MyViewHolder>(DiffCallback()) {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val friendUsername: TextView = itemView.findViewById(R.id.friend_username_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_friend, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.friendUsername.text = getItem(position)
        holder.itemView.setOnClickListener {
            onItemClick(getItem(holder.layoutPosition))
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<String>() { //todo change String to FriendEntity
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem //return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }
}