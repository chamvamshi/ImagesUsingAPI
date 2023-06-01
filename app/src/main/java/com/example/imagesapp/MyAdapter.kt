package com.example.imagesapp

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyAdapter(val context : Activity,val ImagesList : List<MyDataItem>):
RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var title : TextView
        var image : ShapeableImageView
        init {
            title = itemView.findViewById(R.id.Imageheading)
            image = itemView.findViewById(R.id.Image)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val itemView = LayoutInflater.from(context).inflate(R.layout.imageitem,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
      return ImagesList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       var currentItem = ImagesList[position]
        holder.title.text = currentItem.title
        Picasso.get().load(currentItem.thumbnailUrl).into(holder.image)

    }

}


