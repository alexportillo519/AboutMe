package com.alexp.aboutme

import android.content.Context
import android.util.Log
import com.alexp.aboutme.models.Hobby

object HobbyRepository {

    private const val NAME = "AboutMe"
    private var hobbies = mutableListOf<Hobby>(Hobby("Basketball"), Hobby("Football"))

    fun addHobby(hobby: Hobby) {
       hobbies.add(hobby)
    }

    fun getHobbies() : MutableList<Hobby> {
        return hobbies.toMutableList()
    }
}