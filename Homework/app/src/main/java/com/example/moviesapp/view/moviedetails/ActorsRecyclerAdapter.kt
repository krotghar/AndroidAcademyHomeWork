package com.example.moviesapp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.model.Actor
import java.lang.IllegalArgumentException


class ActorsRecyclerAdapter(private val actors: List<Actor>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.actor_view_holder, parent, false)
        return ActorViewHolder(item)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ActorViewHolder) holder.bind(actors[position])
        else throw IllegalArgumentException()
    }

    override fun getItemCount() = actors.size

}