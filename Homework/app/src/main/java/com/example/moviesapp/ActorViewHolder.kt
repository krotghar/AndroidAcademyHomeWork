package com.example.moviesapp

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ActorViewHolder(item: View) : RecyclerView.ViewHolder(item) {
    var actorImg: ImageView? = null
    var actorName: TextView? = null

    init {
        actorImg = item.findViewById(R.id.actor_img_avh)
        actorName = item.findViewById(R.id.actor_name_avh)
    }

    fun bind(actor: Actor) {
        actorName?.text = actor.actorName
        actorImg?.setImageResource(actor.actorImgRef)
    }
}