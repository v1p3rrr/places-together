package com.vpr.places_together.ui.group_screen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vpr.places_together.R

class GroupMembersAdapter(
    private val onModeratorStatusClick: (id: Long) -> Unit,
    private val onRemoveMemberClick: (id: Long) -> Unit
) : //todo change to onItemClick: (id: Long) -> Long)
    ListAdapter<String, GroupMembersAdapter.MyViewHolder>(DiffCallback()) {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val memberUsername: TextView = itemView.findViewById(R.id.member_username_tv)
        val moderatorIcon: ImageView = itemView.findViewById(R.id.icon_moderator)
        val removeMemberIcon: ImageView = itemView.findViewById(R.id.icon_remove_person_from_group)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_member, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.memberUsername.text = getItem(position)
        holder.moderatorIcon.setOnClickListener {
            //onModeratorStatusClick(getItem(holder.layoutPosition).id)
            onModeratorStatusClick(1) //todo
        }
        holder.removeMemberIcon.setOnClickListener {
            //onRemoveMemberClick(getItem(holder.layoutPosition).id)
            onRemoveMemberClick(1)
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