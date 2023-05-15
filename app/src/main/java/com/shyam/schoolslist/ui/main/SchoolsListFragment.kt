package com.shyam.schoolslist.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.shyam.schoolslist.databinding.FragmentSchoolsListBinding
import com.shyam.schoolslist.domain.model.SchoolEntity
import com.shyam.schoolslist.ui.base.UiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SchoolsListFragment : Fragment() {

    private val viewModel: SchoolsListViewModel by viewModels()

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
//                            binding.progressBar.visibility = View.GONE
                            renderList(it.data)
                            binding.schoolListRecyclerView.visibility = View.VISIBLE
                        }
                        is UiState.Loading -> {
//                            binding.progressBar.visibility = View.VISIBLE
                            binding.schoolListRecyclerView.visibility = View.GONE
                        }
                        is UiState.Error -> {
                            //Handle Error
//                            binding.progressBar.visibility = View.GONE
//                            Toast.makeText(this@TopHeadlineActivity, it.message, Toast.LENGTH_LONG)
//                                .show()
                        }
                    }
                }
            }
        }
    }

    private fun renderList(schoolList: List<SchoolEntity>) {
//        adapter.addData(schoolList)
//        adapter.notifyDataSetChanged()
        Log.i("", "Schools response::$schoolList.size")
    }

    private fun setupUI() {
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSchoolsListBinding.inflate(inflater, container, false)

        setupUI()
        setupObserver()

        binding.schoolListRecyclerView.layoutManager = LinearLayoutManager(context)
        // ArrayList of class ItemsViewModel
        val data = ArrayList<SchoolModel>()

        // This loop will create 20 Views containing
        // the image with the count of view
        for (i in 1..20) {
            data.add(SchoolModel("ID$i", "Name $i", "Mobile$i", "Email$i"))
        }

        // This will pass the ArrayList to our Adapter
        val adapter = SchoolListAdapter(data)

        // Setting the Adapter with the recyclerview
        binding.schoolListRecyclerView.adapter = adapter

        return binding.root
    }
}