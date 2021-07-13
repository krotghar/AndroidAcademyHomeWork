package com.example.moviesapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentMoviesDetails : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movies_details, container, false )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = view.findViewById<RecyclerView>(R.id.actors_list)
        val adapter = ActorsRecyclerAdapter(getActorsList())
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        list.adapter = adapter
        list.layoutManager = layoutManager
        list.addItemDecoration(SpaceItemDecorator(4))
    }

    private fun getActorsList(): List<Actor> {
        var actors = mutableListOf<Actor>()
        for (i in 1..4) {
            when (i) {
                1 -> actors.add(Actor("Robert \nDowney Jr.", R.drawable.downey))
                2 -> actors.add(Actor("Chris \nEvans" , R.drawable.chris))
                3 -> actors.add(Actor("Mark \nRuffalo", R.drawable.mark))
                4 -> actors.add(Actor("Chris \nHemsworth", R.drawable.thor))
            }
        }
        return actors
    }
}