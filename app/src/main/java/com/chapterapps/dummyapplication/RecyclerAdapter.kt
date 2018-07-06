package com.chapterapps.dummyapplication

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class RecyclerAdapter(internal var items: ArrayList<String>, private val context: Context?) : RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder(LayoutInflater.from(context).inflate(R.layout.item_row, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.tvAnimalType.text = items.get(position)
        Picasso.get()
                .load("http://i.imgur.com/DvpvklR.png")
                .into(holder.imageView)
    }

    inner class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var tvAnimalType: TextView = itemView.findViewById(R.id.textView)
        var imageView: ImageView = itemView.findViewById(R.id.imageView)
        var i: Int = -1

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            if (i == -1) {
                p0?.setBackgroundColor(ContextCompat.getColor(p0.context, R.color.md_red_300))
                i = adapterPosition
            } else if (i == adapterPosition) {
                p0?.setBackgroundColor(Color.TRANSPARENT)
                i = -1
            } else {

            }
        }
    }
}