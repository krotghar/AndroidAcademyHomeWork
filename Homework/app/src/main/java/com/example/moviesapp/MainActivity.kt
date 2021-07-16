package com.example.moviesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moviesapp.data.JsonMovieRepository
import com.example.moviesapp.data.MovieRepository
import com.example.moviesapp.di.MovieRepositoryProvider
import com.example.moviesapp.model.Movie
import com.example.moviesapp.view.moviedetails.MovieDetailsFragment
import com.example.moviesapp.view.movieslist.MoviesListFragment

class MainActivity : AppCompatActivity(),
    MoviesListFragment.MovieListItemClickListener,
    MovieDetailsFragment.MovieDetailsBackClickListener,
    MovieRepositoryProvider {

    private val jsonMovieRepository = JsonMovieRepository(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null) {
            routeToMoviesList()
        }
    }

    override fun onMovieSelected(movie: Movie) {
        routeToMovieDetails(movie)
    }

    override fun onMovieDeselected() {
        routeBack()
    }

    private fun routeToMoviesList() {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.container,
                MoviesListFragment.create(),
                MoviesListFragment::class.java.simpleName
            )
            .addToBackStack("trans:${MoviesListFragment::class.java.simpleName}")
            .commit()
    }

    private fun routeToMovieDetails(movie: Movie) {
        supportFragmentManager.beginTransaction()
            .add(
                R.id.container,
                MovieDetailsFragment.create(movie.id),
                MovieDetailsFragment::class.java.simpleName
            )
            .addToBackStack("trans:${MovieDetailsFragment::class.java.simpleName}")
            .commit()
    }

    private fun routeBack() {
        supportFragmentManager.popBackStack()
    }

    override fun provideMovieRepository(): MovieRepository = jsonMovieRepository
}
