package com.shyam.schoolslist.ui.main

import com.shyam.schoolslist.domain.model.Record
import com.shyam.schoolslist.domain.repository.SchoolsRepository
import com.shyam.schoolslist.utils.AppConstant
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever


internal class SchoolsListViewModelTest {

    private val repository = mock<SchoolsRepository>()
    private val viewModel = SchoolsListViewModel(repository)

    private val schoolList: List<Record> = ArrayList()

    @Test
    fun `when schools list is not zero - then success state observed`() = runBlocking{
//       whenever(repository.getSchools(AppConstant.RESOURCE, AppConstant.LIMIT)).thenReturn()
        viewModel
//        verify()
    }
}

