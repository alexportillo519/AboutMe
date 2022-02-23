package com.alexp.aboutme

import android.util.Log
import com.alexp.aboutme.models.Hobby

object HobbyRepository {

    private const val TAG = "HobbyRepository"
    private var hobbies = mutableListOf(Hobby("Basketball"), Hobby("Football"))

    fun addHobby(hobby: Hobby) {
        Log.d(TAG, "addHobby($hobby). Hobbies list before: $hobbies")
        hobbies.add(hobby)
    }

    fun getHobbies() : MutableList<Hobby> {
        return hobbies
    }
}