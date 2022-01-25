package com.alexp.aboutme

import android.content.ContentValues.TAG
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.alexp.aboutme.databinding.FragmentHobbiesBinding
import com.alexp.aboutme.databinding.HobbyLayoutBinding
import com.alexp.aboutme.models.Hobby
import com.google.android.material.snackbar.Snackbar

class HobbiesFragment : Fragment(R.layout.fragment_hobbies) {

    private lateinit var binding: FragmentHobbiesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHobbiesBinding.inflate(inflater, container, false)

        val hobbyAdapter = HobbyAdapter(HobbyRepository.getHobbies())

        binding.recyclerView.apply {
            adapter = HobbyAdapter(HobbyRepository.getHobbies())

            layoutManager = LinearLayoutManager(activity)
        }

        binding.addFab.setOnClickListener {
            val newFragment = HobbyDialogFragment()
            newFragment.show(childFragmentManager, "hobby")

            newFragment.onHobbyAdded = {
                binding.recyclerView.adapter = HobbyAdapter(HobbyRepository.getHobbies())
            }
        }




        return binding.root
    }

}