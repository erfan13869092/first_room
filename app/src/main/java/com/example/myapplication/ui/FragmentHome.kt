package com.example.myapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.data.model.ToDo
import com.example.myapplication.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentHome : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val adapterHome = AdapterHome()
    private val addTaskDialog = AddTaskDialogFragment {
        val todo = ToDo(name = it)
        viewModel.addTodo(todo)
    }
    private val viewModel: HomeViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
        onClick()
        getHomeTasks()
    }

    private fun getHomeTasks() {
        viewModel.taskLivaData.observe(viewLifecycleOwner) {
            it?.let {
                adapterHome.task = ArrayList(it)
            }
        }
    }

    private fun onClick() {
        binding.flbtnFragmentHomeAddTask.setOnClickListener {
            addTaskDialog.show(parentFragmentManager, null)

        }
    }

    private fun setRecyclerView() {
        binding.rv.apply {
            adapter = adapterHome
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
}