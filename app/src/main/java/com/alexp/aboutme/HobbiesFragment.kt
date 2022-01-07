package com.alexp.aboutme

import android.content.ContentValues.TAG
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.alexp.aboutme.databinding.FragmentHobbiesBinding
import com.alexp.aboutme.models.Hobby
import com.google.android.material.snackbar.Snackbar

class HobbiesFragment : Fragment(R.layout.fragment_hobbies) {

    private lateinit var binding: FragmentHobbiesBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHobbiesBinding.inflate(inflater, container, false)


        binding.recyclerView.apply {
            adapter = HobbyAdapter(HobbyRepository.getHobbies())

            layoutManager = LinearLayoutManager(activity)
        }



        binding.addFab.setOnClickListener {
            val newFragment = HobbyDialogFragment()
            newFragment.show(childFragmentManager, "hobby")
            // lets the recyclerView know you have new data
            binding.recyclerView.adapter?.notifyDataSetChanged()
        }

        return binding.root
    }

}