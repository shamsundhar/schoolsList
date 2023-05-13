package com.shyam.schoolslist.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.shyam.schoolslist.R

class SchoolsListFragment : Fragment() {
    private val viewModel by viewModels<SchoolsListViewModel>()
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
    ): View? {
        return inflater.inflate(R.layout.fragment_schools_list, container, false)
    }
}