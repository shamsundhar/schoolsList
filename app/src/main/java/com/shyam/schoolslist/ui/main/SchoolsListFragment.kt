package com.shyam.schoolslist.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.shyam.schoolslist.databinding.FragmentSchoolsListBinding

class SchoolsListFragment : Fragment() {
    private val viewModel by viewModels<SchoolsListViewModel>()
    private lateinit var binding: FragmentSchoolsListBinding
    companion object {
        fun newInstance() = SchoolsListFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSchoolsListBinding.inflate(inflater, container, false)



        return binding.root
    }
}