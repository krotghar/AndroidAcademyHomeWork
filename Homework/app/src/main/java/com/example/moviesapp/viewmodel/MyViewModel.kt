package com.example.moviesapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviesapp.model.Actor
import com.example.moviesapp.model.Movie

class MyViewModel()  : ViewModel() {

    private val moviesList: MutableLiveData<List<Movie>> by lazy {
        MutableLiveData<List<Movie>>().also {
            loadMovies()
        }
    }

    private val actorList: MutableLiveData<List<Actor>> by lazy {
        MutableLiveData<List<Actor>>().also {
            loadActor()
        }
    }

    fun getMovies(): LiveData<List<Movie>> {
        return moviesList
    }

    fun getActors(): LiveData<List<Actor>> {
        return actorList
    }

    private fun loadActor() {

    }

    private fun loadMovies() {

    }
}