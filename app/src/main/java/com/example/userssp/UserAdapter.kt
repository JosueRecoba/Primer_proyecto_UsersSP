package com.example.userssp

import android.content.Context
import android.system.Os.bind
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(private val users: List<User>, private val listener: View.OnClickListener) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>(){

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context

        val view = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val user = users.get(position)

       with(holder){
           setListener(user, position + 1)
           binding.tvOrder.text = (position + 1).toString()
           binding.tvName.text = user.name + "" + user.lastName
           Glide.with(context)
               .load(user.url)
               .diskCacheStrategy(DiskCacheStrategy.ALL)
               .centerCrop()
               .circleCrop()
               .into(binding.imgPhoto)



       }
    }

    override fun getItemCount(): Int = users.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val binding = ItemUserBinding.bind(view)

        fun setListener(user: User, position: Int){
            binding.root.setONClickListener {listener.onClick(user, position)}
        }

    }
}