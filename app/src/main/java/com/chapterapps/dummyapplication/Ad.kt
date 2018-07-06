package com.chapterapps.dummyapplication

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class Ad(internal var List: ArrayList<String>) : RecyclerView.Adapter<Ad.Vh>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    inner class Vh(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        override fun onClick(view: View) {
            List[getAdapterPosition()]
        }
    }
}
