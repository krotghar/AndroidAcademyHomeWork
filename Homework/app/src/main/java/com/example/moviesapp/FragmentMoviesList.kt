package com.example.moviesapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentMoviesList : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = view.findViewById<RecyclerView>(R.id.movies_list)
        val adapter = MovieRecyclerAdapter(createMovieContentList(), clickListener)
        val layoutManager = GridLayoutManager(activity, 2, RecyclerView.VERTICAL, false)
        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (position) {
                    0 -> 2
                    else -> 1
                }
            }
        }
        list.adapter = adapter
        list.layoutManager = layoutManager
    }


    private fun createMovieContentList(): List<MovieCardContent> {
        val movieCardContentList = mutableListOf<MovieCardContent>()
        for (i in  0..3){
            when (i) {
                0 -> movieCardContentList.add(MovieCardContent(
                    "Avengers: End Game",
                    "13+",
                    R.drawable.movie_img,
                    "Actions, Adventure",
                    "125 reviews",
                    "137 min",
                    4f
                ))
                1 -> movieCardContentList.add(MovieCardContent(
                    "Tenet",
                    "16+",
                    R.drawable.tenet,
                    "Actions, Sci-Fi, Thriller",
                    "198 reviews",
                    "97 min",
                    5f
                ))
                2 -> movieCardContentList.add(MovieCardContent(
                    "Black Widow",
                    "13+",
                    R.drawable.black_widow,
                    "Actions, Adventure, Sci-Fi",
                    "38 reviews",
                    "102 min",
                    4f
                ))
                3 -> movieCardContentList.add(MovieCardContent(
                    "Wonder Woman 1984",
                    "13+",
                    R.drawable.wonder_woman,
                    "Actions, Adventure, Fantasy",
                    "74 reviews",
                    "120 min",
                    5f
                ))
            }
        }


        return movieCardContentList
    }

    private val clickListener = object : MovieRecyclerAdapter.ClickListener {
        override fun onClick(movie: MovieCardContent) {
            if (movie?.titleMovie == "Avengers: End Game") {
                val fragmentMoviesDetails = FragmentMoviesDetails()
                val fragmentManager = activity?.supportFragmentManager
                fragmentManager?.beginTransaction()
                    ?.add(R.id.movies_details_frame, fragmentMoviesDetails)
                    ?.addToBackStack(null)
                    ?.commit()
            }
        }
    }


}
