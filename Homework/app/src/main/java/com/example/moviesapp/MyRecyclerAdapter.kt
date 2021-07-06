package com.example.moviesapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerAdapter(private val movies: List<MovieCardContent>) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_movie, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.movieTitle?.text = movies[position].titleMovie
        holder.pg?.text = movies[position].pg
        holder.bgCard?.setImageResource(movies[position].bgRef)
        holder.genres?.text = movies[position].genres
        holder.reviews?.text = movies[position].reviews
        holder.time?.text = movies[position].time
        holder.ratingBar?.rating = movies[position].rating
    }

    override fun getItemCount() = movies.size
}