package com.alexp.aboutme

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.alexp.aboutme.databinding.FragmentHobbiesBinding
import com.alexp.aboutme.databinding.HobbyLayoutBinding
import com.alexp.aboutme.databinding.HobbyListBinding
import com.alexp.aboutme.models.Hobby
import com.google.android.material.snackbar.Snackbar
import java.lang.IllegalStateException

class HobbyDialogFragment : DialogFragment() {

    var onHobbyAdded: () -> Unit = {}

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val binding = HobbyLayoutBinding.inflate(layoutInflater)
        return activity?.let {
            val builder = AlertDialog.Builder(it)

            builder.setView(binding.root)
                    .setPositiveButton(R.string.add_text,
                            DialogInterface.OnClickListener { _, _ ->
                                val newHobby = binding.titleUserInput.text.toString()
                                HobbyRepository.addHobby(Hobby(newHobby))
                                onHobbyAdded()
                                Toast.makeText(context, "Hobby Added", Toast.LENGTH_SHORT).show()
                            })
                    .setNegativeButton(R.string.cancel_text,
                            DialogInterface.OnClickListener { _, _ ->
                                dialog?.dismiss()
                                Toast.makeText(context, "CANCEL", Toast.LENGTH_SHORT).show()
                    })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}