package com.shyam.schoolslist.ui.main

import com.shyam.schoolslist.domain.model.Record
import com.shyam.schoolslist.domain.repository.SchoolsRepository
import com.shyam.schoolslist.ui.base.UiState
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class SchoolsListViewModelTest {

    @JvmField
    @Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val repository = mock<SchoolsRepository>()
    private val viewModel = SchoolsListViewModel(repository)

    @Before
    fun setup() {

    }

    @Test
    fun `uiInitialised - schools list is not zero - then success state observed`() = runTest {
        // Given
        whenever(repository.getSchools(any(), any())).thenReturn(getSchoolsAsFlow())
        // When
        viewModel.uiInitialised()
        // Then
        val state = viewModel.uiState.value as UiState.Success
        assertEquals(state.data[0].Telephone, "12335453")
        assertEquals(state.data[0].Email, "test@test.com")
    }

    private fun getSchoolsAsFlow(): Flow<List<Record>> = flow {
        val schoolList: MutableList<Record> = mutableListOf()
        val record = Record(
            School_Id = 123, Org_Name = "Testing School",
            Telephone = "12335453", Email = "test@test.com"
        )
        schoolList.add(record)
        emit(schoolList)
    }


}

