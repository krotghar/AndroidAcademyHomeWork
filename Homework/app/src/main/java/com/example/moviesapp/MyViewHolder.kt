package com.example.moviesapp

import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var genres: TextView? = null
    var pg: TextView? = null
    var bgCard: ImageView? = null
    var movieTitle: TextView? = null
    var reviews: TextView? = null
    var time: TextView? = null
    var ratingBar: RatingBar? = null
    init{
        genres = itemView.findViewById(R.id.genres)
        pg = itemView.findViewById(R.id.pg)
        bgCard = itemView.findViewById(R.id.card_bg)
        movieTitle = itemView.findViewById(R.id.title_movie)
        reviews = itemView.findViewById(R.id.reviews)
        time = itemView.findViewById(R.id.time)
        ratingBar = itemView.findViewById(R.id.rating_bar)
    }
}