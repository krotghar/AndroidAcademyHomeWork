package com.example.moviesapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.lang.IllegalArgumentException

class MovieRecyclerAdapter(private val movies: List<MovieCardContent>,
                           private val clickListener: ClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        /*val itemView = LayoutInflater.from(parent.context).inflate(R.layout.view_holder_movie, parent, false)
        return ActorViewHolder(itemView)*/
        return when (viewType) {
            TYPE_HEADER -> HeaderViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_holder_header_movie_list, parent, false))
            TYPE_MOVIE -> MovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_holder_movie, parent, false))
            else -> throw IllegalArgumentException()
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        /*holder.movieTitle?.text = movies[position].titleMovie
        holder.pg?.text = movies[position].pg
        holder.bgCard?.setImageResource(movies[position].bgRef)
        holder.genres?.text = movies[position].genres
        holder.reviews?.text = movies[position].reviews
        holder.time?.text = movies[position].time
        holder.ratingBar?.rating = movies[position].rating*/
        when (holder) {
            is MovieViewHolder -> holder.bind(getItem(position))
        }
        holder.itemView.setOnClickListener {
            clickListener.onClick(movies[position - 1])
        }
    }

    override fun getItemCount() = movies.size + 1

    fun getItem(position: Int): MovieCardContent = movies[position - 1]

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> TYPE_HEADER
            else -> TYPE_MOVIE
        }
    }

    companion object {
        private const val TYPE_HEADER = 0
        private const val TYPE_MOVIE = 1
    }

    interface ClickListener {
        fun onClick(movie: MovieCardContent)
    }
}