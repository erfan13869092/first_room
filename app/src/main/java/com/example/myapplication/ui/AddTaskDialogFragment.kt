package com.example.myapplication.ui

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.myapplication.databinding.AddTaskDialogFragmentBinding
import com.example.myapplication.databinding.FragmentHomeBinding

class AddTaskDialogFragment(val nameTask:(String)->Unit):DialogFragment() {
    private var _binding: AddTaskDialogFragmentBinding? = null
    private val binding get () = _binding!!
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialogView=AlertDialog.Builder(requireContext()).create()
        _binding=AddTaskDialogFragmentBinding.inflate(layoutInflater,null,false)
        dialogView.setView(binding.root)

        onClick()
        return dialogView
    }

    private fun getTaskName():String {
        return binding.editTextText.text.toString()
    }

    private fun onClick() {
        binding.btnAddTaskDialogOk.setOnClickListener {
            nameTask(getTaskName())
            dismiss()
        }
        binding.btnAddTaskDialogCancel.setOnClickListener {
            dismiss()
        }
    }
}