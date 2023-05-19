package com.shyam.schoolslist.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.shyam.schoolslist.databinding.FragmentSchoolsListBinding
import com.shyam.schoolslist.domain.model.Record
import com.shyam.schoolslist.ui.base.UiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SchoolsListFragment : Fragment() {

    private val viewModel: SchoolsListViewModel by viewModels()
    private lateinit var adapter: SchoolListAdapter

    private lateinit var binding: FragmentSchoolsListBinding
    companion object {
        fun newInstance() = SchoolsListFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun setupObserver() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {
                    when (it) {
                        is UiState.Success -> {
                            binding.progressBar.visibility = View.GONE
                            renderList(it.data)
                            binding.schoolListRecyclerView.visibility = View.VISIBLE
                        }
                        is UiState.Loading -> {
                            binding.progressBar.visibility = View.VISIBLE
                            binding.schoolListRecyclerView.visibility = View.GONE
                        }
                        is UiState.Error -> {
                            //Handle Error
                            binding.progressBar.visibility = View.GONE
                            Toast.makeText(activity, it.message, Toast.LENGTH_LONG)
                                .show()
                        }
                    }
                }
            }
        }
    }

    private fun renderList(schoolList: List<Record>) {
        Log.i("", "Schools response::$schoolList.size")
        adapter.addData(schoolList)
    }

    private fun setupUI() {
        binding.schoolListRecyclerView.layoutManager = LinearLayoutManager(context)
        adapter = SchoolListAdapter()
        // Setting the Adapter with the recyclerview
        binding.schoolListRecyclerView.adapter = adapter
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSchoolsListBinding.inflate(inflater, container, false)

        setupUI()
        setupObserver()

        return binding.root
    }
}