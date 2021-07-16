package com.example.moviesapp.view.moviedetails

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesapp.R
import com.example.moviesapp.model.Actor

class ActorViewHolder(item: View) : RecyclerView.ViewHolder(item) {
    private val actorImg: ImageView = item.findViewById(R.id.actor_image)
    private val actorName: TextView = item.findViewById(R.id.actor_name)


    fun bind(actor: Actor) {
        actorName.text = actor.name
        Glide.with(itemView).load(actor.imageUrl).into(actorImg)
    }

}