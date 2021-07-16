package com.example.moviesapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviesapp.model.Actor

class SharedViewModel : ViewModel() {
    private val actorsList = MutableLiveData<List<Actor>>()
    val publicActorList = actorsList
}