package com.alexp.aboutme

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alexp.aboutme.databinding.HobbyLayoutBinding
import com.alexp.aboutme.databinding.HobbyListBinding
import com.alexp.aboutme.models.Hobby

class HobbyAdapter(
        private val hobbiesList: MutableList<Hobby>
) : RecyclerView.Adapter<HobbyAdapter.HobbyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HobbyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = HobbyListBinding.inflate(inflater)
        return HobbyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HobbyViewHolder, position: Int) {
        holder.onBind(hobbiesList[position])
    }

    override fun getItemCount() = hobbiesList.size

    class HobbyViewHolder(
            private val binding: HobbyListBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(hobby: Hobby) = binding.apply {
            hobbyText.text = hobby.hobbies
        }
    }
}