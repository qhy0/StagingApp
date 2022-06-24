package com.example.stageapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.stageapp.R
import androidx.recyclerview.widget.RecyclerView
import com.example.stageapp.main_activity.RecyclerItemClickListener
import com.example.stageapp.model.UserInfo


 class UserRecyclerAdapter(
    var dataList: List<UserInfo>,
    var recyclerItemClickListener: RecyclerItemClickListener
) :RecyclerView.Adapter<UserRecyclerAdapter.UserInfoViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserInfoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return UserInfoViewHolder(layoutInflater.inflate(R.layout.user_data_item, parent, false))
    }
    override fun onBindViewHolder(holder: UserRecyclerAdapter.UserInfoViewHolder, position: Int) {
        holder.txtname.text= dataList[position].name
        holder.txtemail.text=dataList[position].email
        holder.itemView.setOnClickListener { recyclerItemClickListener.onItemClick(dataList[position]) }
    }

    override fun getItemCount(): Int {
        return  dataList.size
    }

    inner class UserInfoViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var txtname: TextView
        var txtemail: TextView
        var imageName: ImageView

        init {
            txtname= itemView.findViewById(R.id.name)
            txtemail= itemView.findViewById(R.id.email)
            imageName= itemView.findViewById(R.id.image_name)
        }
    }
    init {
        this.dataList = dataList
        this.recyclerItemClickListener = recyclerItemClickListener
    }
}
