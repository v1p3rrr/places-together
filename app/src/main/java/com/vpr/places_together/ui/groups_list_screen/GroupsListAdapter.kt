package com.vpr.places_together.ui.groups_list_screen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vpr.places_together.R
import com.vpr.places_together.ui.friends_screen.FriendsAdapter

class GroupsListAdapter(private val onItemClick: (id: Long) -> Long) : //todo change to onItemClick: (id: Long) -> Long)
    ListAdapter<String, GroupsListAdapter.MyViewHolder>(DiffCallback()) {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val groupName: TextView = itemView.findViewById(R.id.group_name_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_group, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.groupName.text = getItem(position)
        holder.itemView.setOnClickListener {
            //onItemClick(getItem(holder.layoutPosition).id)
            onItemClick(1) //todo
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