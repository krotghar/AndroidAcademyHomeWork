package com.example.moviesapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.R
import com.example.moviesapp.model.Movie
import com.example.moviesapp.viewmodel.MyViewModel
import com.example.moviesapp.viewmodel.SharedViewModel

class FragmentMoviesList : Fragment() {

    private val sharedModel: SharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var movies: List<Movie>? = null
        val viewModel: MyViewModel by viewModels()
        viewModel.getMovies().observe(this, Observer<List<Movie>>{ _movies ->
            movies = _movies
        })
        val list = view.findViewById<RecyclerView>(R.id.movies_list)
        val adapter = MovieRecyclerAdapter(movies, clickListener)
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


    /*private fun createMovieContentList(): List<Movie> {
        val movieCardContentList = mutableListOf<Movie>()
        for (i in  0..3){
            when (i) {
                0 -> movieCardContentList.add(
                    Movie(
                        "Avengers: End Game",
                        "13+",
                        R.drawable.movie_img,
                        "Actions, Adventure",
                        "125 reviews",
                        "137 min",
                        4f,
                        if (jsonMovie.adult) 16 else 13,
                        jsonMovie.runtime,
                        jsonMovie.genreIds.map { id ->
                            genresMap[id].orThrow { IllegalArgumentException("Genre not found") }
                        },
                        jsonMovie.actors.map { id ->
                            actorsMap[id].orThrow { IllegalArgumentException("Actor not found") }
                        },
                        false
                    )
                )
                1 -> movieCardContentList.add(
                    Movie(
                        "Tenet",
                        "16+",
                        R.drawable.tenet,
                        "Actions, Sci-Fi, Thriller",
                        "198 reviews",
                        "97 min",
                        5f,
                        if (jsonMovie.adult) 16 else 13,
                        jsonMovie.runtime,
                        jsonMovie.genreIds.map { id ->
                            genresMap[id].orThrow { IllegalArgumentException("Genre not found") }
                        },
                        jsonMovie.actors.map { id ->
                            actorsMap[id].orThrow { IllegalArgumentException("Actor not found") }
                        },
                        false
                    )
                )
                2 -> movieCardContentList.add(
                    Movie(
                        "Black Widow",
                        "13+",
                        R.drawable.black_widow,
                        "Actions, Adventure, Sci-Fi",
                        "38 reviews",
                        "102 min",
                        4f,
                        if (jsonMovie.adult) 16 else 13,
                        jsonMovie.runtime,
                        jsonMovie.genreIds.map { id ->
                            genresMap[id].orThrow { IllegalArgumentException("Genre not found") }
                        },
                        jsonMovie.actors.map { id ->
                            actorsMap[id].orThrow { IllegalArgumentException("Actor not found") }
                        },
                        false
                    )
                )
                3 -> movieCardContentList.add(
                    Movie(
                        "Wonder Woman 1984",
                        "13+",
                        R.drawable.wonder_woman,
                        "Actions, Adventure, Fantasy",
                        "74 reviews",
                        "120 min",
                        5f,
                        if (jsonMovie.adult) 16 else 13,
                        jsonMovie.runtime,
                        jsonMovie.genreIds.map { id ->
                            genresMap[id].orThrow { IllegalArgumentException("Genre not found") }
                        },
                        jsonMovie.actors.map { id ->
                            actorsMap[id].orThrow { IllegalArgumentException("Actor not found") }
                        },
                        false
                    )
                )
            }
        }


        return movieCardContentList
    }*/

    private val clickListener = object : MovieRecyclerAdapter.ClickListener {
        override fun onClick(movie: Movie) {
            sharedModel.publicActorList.value = movie.actors
            val fragmentMoviesDetails = FragmentMoviesDetails()

        }
    }

}
