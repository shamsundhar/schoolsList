package com.shyam.schoolslist.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shyam.schoolslist.domain.model.Record
import com.shyam.schoolslist.domain.repository.SchoolsRepository
import com.shyam.schoolslist.ui.base.UiState
import com.shyam.schoolslist.utils.AppConstant
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SchoolsListViewModel @Inject constructor(
    private val schoolsRepository: SchoolsRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<List<Record>>>(UiState.Loading)

    val uiState: StateFlow<UiState<List<Record>>> = _uiState

    private fun fetchSchools() {
        viewModelScope.launch {
            try {
                schoolsRepository.getSchools(AppConstant.RESOURCE, AppConstant.LIMIT)
                    .collect {
                        _uiState.value = UiState.Success(it)
                    }
            } catch (t: Throwable) {
                _uiState.value = UiState.Error(t.toString())
            }
        }
    }

    fun uiInitialised() {
        fetchSchools()
    }
}