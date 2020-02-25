package com.example.simpleretrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class CustomAdapter(val context: Context,val dataList : List<PhotoData>) : RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {

    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtDesc = itemView.findViewById<TextView>(R.id.txt_description)!!
        val imgThumbnail = itemView.findViewById<ImageView>(R.id.img_thumbnail)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_row,parent,false)
        return CustomViewHolder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        holder.txtDesc.text = dataList[position].title

        Picasso.with(context).load(dataList[position].thumbnailUrl).into(holder.imgThumbnail)

    }
}

