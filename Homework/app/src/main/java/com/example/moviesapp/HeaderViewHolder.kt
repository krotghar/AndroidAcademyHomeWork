package com.example.moviesapp

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind() {
    }

    var img: ImageView? = null
    var tv: TextView? = null
    init {
        img = itemView.findViewById(R.id.header_iv)
        tv = itemView.findViewById(R.id.header_tv)
    }
}