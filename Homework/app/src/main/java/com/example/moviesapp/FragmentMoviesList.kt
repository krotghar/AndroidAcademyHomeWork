package com.example.moviesapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentMoviesList : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        return inflater.inflate(R.layout.fragment_movies_list,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = view.findViewById<RecyclerView>(R.id.movies_list)
        val adapter = MyRecyclerAdapter()
        list.adapter = adapter
        list.layoutManager = GridLayoutManager(activity,2, RecyclerView.VERTICAL, false)
    }

    companion object MovieCardContentList {
        val movieCardContentList = mutableListOf<MovieCardContent>()
        val init = {
            for (i in  0..4){
               when (i) {
                   0 -> movieCardContentList.add(MovieCardContent(
                           "Avengers: End Game",
                           "13+",
                           R.drawable.movie_img,
                           "Actions, Adventure",
                           "125 review",
                           "125 min",
                           4F
                   ))
                   1 -> movieCardContentList.add(MovieCardContent(
                           
                   ))
               }
            }
        }

    }
}
