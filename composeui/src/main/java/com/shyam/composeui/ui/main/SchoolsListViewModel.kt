package com.shyam.composeui.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shyam.composeui.domain.model.Record
import com.shyam.composeui.domain.repository.SchoolsRepository
import com.shyam.composeui.utils.AppConstant
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SchoolsListViewModel @Inject constructor(
    private val schoolsRepository: SchoolsRepository
) : ViewModel() {

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _schools = MutableStateFlow<List<Record>>(emptyList())
    val schools: StateFlow<List<Record>> = _schools

    init {
        fetchSchools()
    }

    private fun fetchSchools() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val result = schoolsRepository.getSchools(AppConstant.RESOURCE, AppConstant.LIMIT)
                _schools.value = result
                _isLoading.value = false
            } catch (e: java.lang.Exception) {
                _isLoading.value = false
            }
        }
    }
}